package com.example.SpringSecurityLab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class CustomUserDetailsService {
    InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

    @Bean
    public UserDetailsService userDetailsService() {
        users.createUser(
                User.withUsername("john")
//                        .password("{noop}password")
                        .password(passwordEncoder().encode("password"))
                        .roles("EMPLOYEE").build()
        );
        users.createUser(
                User.withUsername("mary")
//                        .password("{noop}test123")
                        .password(passwordEncoder().encode("test123"))
                        .roles("MANAGER").build()
        );
        users.createUser(
                User.withUsername("Jessy")
//                        .password("{noop}admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN").build()
        );
        return users;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
