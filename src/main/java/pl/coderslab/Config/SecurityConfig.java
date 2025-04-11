package pl.coderslab.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/start", "/user/add").permitAll()
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )

                .formLogin(form -> form
                        .loginPage("/start") // <-- twoja strona logowania (GET)
                        .loginProcessingUrl("/user/login") // <-- tu leci POST z formularza
                        .defaultSuccessUrl("/listPages/CarList", true)
                        .permitAll()
                )

//                .sessionManagement(session -> session
//                        .maximumSessions(1)  // Limit number of sessions per user
//                        .expiredUrl("/user/start")  // Redirect to the login page if the session expires
//                )
        ;


        return http.build();
    }
}
