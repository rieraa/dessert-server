//package com.example.desserts.config;
//
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SecurityConfiguration {
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> {
////                    auth.requestMatchers("/static/**").permitAll();
//                    auth.anyRequest().permitAll();
//                })
//                .formLogin(conf -> {
//                    conf.loginPage("/login");
//                    conf.loginProcessingUrl("/doLogin");
//                    conf.defaultSuccessUrl("/");
//                    conf.permitAll();
//                })
//                .build();
//    }
//}
