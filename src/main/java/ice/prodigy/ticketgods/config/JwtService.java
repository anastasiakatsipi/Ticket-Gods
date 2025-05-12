package ice.prodigy.ticketgods.config;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
    //hash κλειδι για encoding
    private static final String SECRET_KEY = "27e29d6185bc37cf77bbac420d5e93a385641b508e1a2d8cfe1c61c8b700c984";

    //λήψη username
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //Ληψη ολων τον προσπαθειων για connection
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }   

    //ελεγχος αν το token ειναι valid
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    } 

    //ελεγχος αν το token ειναι expired
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //ληψη expiration του token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //δημιουργια token
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    //δημουργια token
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
        .claims(extraClaims)
        .subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .signWith(getSignIngKey(), Jwts.SIG.HS256)
        .compact();
    }
    
    //verification με το token
    private Claims extractAllClaims(String token){
        return Jwts.parser()
        .verifyWith(getSignIngKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }

    private SecretKey getSignIngKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
