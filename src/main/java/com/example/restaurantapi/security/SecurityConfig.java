package com.example.restaurantapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)

public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(autz ->
                        autz
                                .requestMatchers("rating/**").hasRole("GUEST")
                                .requestMatchers("reservationClient/**").hasRole("GUEST")
                                .requestMatchers("reservationHost/**").hasRole("HOST")
                                .requestMatchers("restaurant/**").hasRole("HOST")
                                .requestMatchers("tables/**").hasRole("HOST")

                )
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizerH2() {
        return (web) -> web.ignoring()
                .requestMatchers("/h2-console/**")
                .requestMatchers("/swagger-ui/**");
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("Gordon")
                .password(encoder().encode("pass"))
                .roles("HOST")
                .build();
        UserDetails user2 = User.builder()
                .username("Henry")
                .password(encoder().encode("pass"))
                .roles("GUEST")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }


    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }
}
