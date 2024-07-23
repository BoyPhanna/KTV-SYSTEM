package com.example.ktv.configs;

import com.example.ktv.services.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityFilter {

private final TokenFilter tokenFilter;
private final TokenService tokenService;
    public SecurityFilter(TokenFilter tokenFilter, TokenService tokenService) {

        this.tokenFilter = tokenFilter;
        this.tokenService = tokenService;
    }

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

//                    System.out.println("Hello boy role");
//                    authConfig.requestMatchers(HttpMethod.POST,"/customer/login").permitAll();
//                    authConfig.requestMatchers(HttpMethod.POST,"/customer/register").permitAll();
//                    authConfig.requestMatchers(HttpMethod.POST,"/customer/verify").permitAll();
//                    authConfig.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll();
//                    authConfig.requestMatchers(HttpMethod.GET,"/customer/verify").hasRole("CUSTOMER");
//                    authConfig.requestMatchers(HttpMethod.GET,"/hello/boy").hasRole("CUSTOMER");



                    authConfig.anyRequest().authenticated();


                })
                .addFilterAfter(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        return  http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
