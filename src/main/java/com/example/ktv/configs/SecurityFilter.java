package com.example.ktv.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilter {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrfConfig->csrfConfig.disable())
                .sessionManagement(sessionMangConfig->sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authConfig->{
                    authConfig.requestMatchers(HttpMethod.GET,"/hello/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.GET,"/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.PATCH,"/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST,"/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.PUT,"/**").permitAll();
                    authConfig.requestMatchers(HttpMethod.DELETE,"/**").permitAll();

                    authConfig.anyRequest().denyAll();
                });

        return  http.build();
    }
}
