package com.lab7.config;

import com.lab7.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/main", "/register").permitAll()
                        .requestMatchers("/user","/updateUser/*******", "/deleteUser/*******",
                                "/createUser", "/updateUser",
                                "/createUser/****").hasAuthority("user")
                        .requestMatchers("/admin","/createQuest", "/deleteQuest/*******",
                                "/updateQuest","/updateQuest/*******",
                                "/createQuest/****"
                                ).hasAuthority("admin")

                )
                .logout((logout) -> logout.permitAll());
        http.csrf().disable();

        return http.build();
    }
}
