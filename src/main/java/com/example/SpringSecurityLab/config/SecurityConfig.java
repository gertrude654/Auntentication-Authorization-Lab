//package com.example.SpringSecurityLab.config;
//
//import com.example.SpringSecurityLab.jwt.JwtRequestFilter;
//import com.example.SpringSecurityLab.jwt.JwtUtil;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtRequestFilter jwtFilter;
//    private UserDetails userDetailsService;
//
//    // Constructor injection for JwtRequestFilter
//
//
//    public SecurityConfig(JwtRequestFilter jwtFilter, UserDetails userDetailsService) {
//        this.jwtFilter = jwtFilter;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) ->
//                        authorize.requestMatchers("/home","/authenticate").permitAll()
//                                .requestMatchers("/manager/**").hasRole("MANAGER")
//                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .formLogin(
//                        form -> form
//                                .defaultSuccessUrl("/home", true)
//                )
//                .logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll()
//                )
//                .exceptionHandling(exception ->
//                        exception.accessDeniedPage("/access-denied")
//                )
//                .csrf().disable(); // Disable CSRF if using JWT
//        return http.build();
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                new AuthenticationManagerBuilder(http.getSharedObject(BeanFactory.class));
//        authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
//
//
//
//}


//package com.example.SpringSecurityLab.config;
//
//import com.example.SpringSecurityLab.jwt.JwtRequestFilter;
//import com.example.SpringSecurityLab.jwt.JwtUtil;
//import org.apache.naming.factory.BeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Autowired
//    private JwtRequestFilter jwtFilter;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) ->
//                        authorize.requestMatchers("/home").permitAll()
//                                .requestMatchers("/manager/**").hasRole("MANAGER")
//                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .csrf().disable(); // Disable CSRF for JWT-based authentication
//        return http.build();
//    }
//
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder =
////                new AuthenticationManagerBuilder(http.getSharedObject(BeanFactory.class));
////        authenticationManagerBuilder.userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////        return authenticationManagerBuilder.build();
////    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                new AuthenticationManagerBuilder(http.getSharedObject(BeanFactory.class));
//        authenticationManagerBuilder.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}



package com.example.SpringSecurityLab.config;

import com.example.SpringSecurityLab.jwt.JwtRequestFilter;
import com.example.SpringSecurityLab.jwt.JwtUtil;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private JwtRequestFilter jwtFilter;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/home").permitAll()
                                .requestMatchers("/manager/**").hasRole("MANAGER")
                                .requestMatchers("/employee/**").hasRole("EMPLOYEE")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(
                        form -> form
                                .defaultSuccessUrl("/home", true)
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                )
                .exceptionHandling(exception ->
                        exception.accessDeniedPage("/access-denied")
                )
                .csrf().disable(); // Disable CSRF for JWT-based authentication
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
