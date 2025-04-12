package pl.coderslab.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
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
                .formLogin(form -> form
                        .loginPage("/login/log")               // GET — pokazuje formularz logowania
                        .loginProcessingUrl("/login")      // POST — Spring obsługuje logowanie
                        .defaultSuccessUrl("/user/cars", true) // Możesz tu dynamicznie przekierować po zalogowaniu
                        .failureUrl("/failure")
                        .permitAll()
//                )
                );
//
//                .logout(logout -> logout
//                        .logoutUrl("/user/logout")          // adres do wylogowania
//                        .logoutSuccessUrl("/start")         // gdzie przekierować po wylogowaniu
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .permitAll()
//                );
//
        return http.build();
    }

}
