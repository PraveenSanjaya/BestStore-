package com.bmt.beststore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/store/**").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        //.requestMatchers("/user").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> {})
                .oauth2Login(config -> {})
                .logout(config -> {})
                .logout(config -> config.logoutSuccessUrl("/"))
                .build();
                //.oauth2Login(Customizer.withDefaults())
                //.formLogin(Customizer.withDefaults());
               //return http.build();
    }

}
