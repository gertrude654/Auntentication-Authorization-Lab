package com.example.SpringSecurityLab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService  implements UserDetailsService {
    InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

    @Bean
    public UserDetailsService userDetailsService() {
        users.createUser(
                User.withUsername("john")
                        .password("{noop}password")
//                        .password(passwordEncoder().encode("password"))
                        .roles("EMPLOYEE").build()
        );
        users.createUser(
                User.withUsername("mary")
                        .password("{noop}test123")
//                        .password(passwordEncoder().encode("test123"))
                        .roles("MANAGER").build()
        );
        users.createUser(
                User.withUsername("Jessy")
                        .password("{noop}admin")
//                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN").build()
        );
        return users;
    }

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = users.loadUserByUsername(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return userDetails;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}
//
//package com.example.SpringSecurityLab.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;
//
//    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
//        this.inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(
//                User.withUsername("john")
//                        .password(passwordEncoder.encode("password"))
//                        .roles("EMPLOYEE").build()
//        );
//        inMemoryUserDetailsManager.createUser(
//                User.withUsername("mary")
//                        .password(passwordEncoder.encode("test123"))
//                        .roles("MANAGER").build()
//        );
//        inMemoryUserDetailsManager.createUser(
//                User.withUsername("Jessy")
//                        .password(passwordEncoder.encode("admin"))
//                        .roles("ADMIN").build()
//        );
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(username);
//        if (userDetails == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return userDetails;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
