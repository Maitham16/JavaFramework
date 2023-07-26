// package com.example.mcv.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public UserDetailsService userDetailsService() {
//         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//         manager.createUser(User
//                 .withUsername("user")
//                 .password(passwordEncoder().encode("password"))
//                 .roles("USER")
//                 .build());
//         return manager;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//     }
// }