package ice.prodigy.ticketgods.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ice.prodigy.ticketgods.user.User;
import ice.prodigy.ticketgods.config.JwtService;
import ice.prodigy.ticketgods.user.Role;
import ice.prodigy.ticketgods.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    
    //service για register του χρήστη
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
        .username(request.getUsername())
        .mail(request.getMail())
        .passwords(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();

        repo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    //Service για authentication του χρήστη
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = repo.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
