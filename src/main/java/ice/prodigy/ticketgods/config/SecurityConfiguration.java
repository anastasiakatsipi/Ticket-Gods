package ice.prodigy.ticketgods.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.Customizer;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration{

        private final JwtFilter jwtAuthFilter;
        private final AuthenticationProvider authenticationProvider;

        //Configurration για το τι επιτρέπετε να αποστέλεται και να λαμβάνεται και πως πρεπει να γινει η επικοινωνια μετα το authentication
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
                http
                        .csrf(AbstractHttpConfigurer::disable)
                        .cors(Customizer.withDefaults())
                        .authorizeHttpRequests(request -> request.requestMatchers("/api/auth/**", "/api/cineapi/**","/api/conapi/**","/api/musapi/**","/api/spoapi/**","/api/bookapi/**").permitAll()
                        .anyRequest().authenticated())
                        .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }
}