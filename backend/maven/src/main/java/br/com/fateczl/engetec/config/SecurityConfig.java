//package br.com.fateczl.engetec.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import io.swagger.v3.oas.models.PathItem.HttpMethod;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(
//            		(authz) -> 
//							authz						
//							.requestMatchers("/aluno/**").hasRole("ALUNO")
//							.requestMatchers("/professor/**").hasRole("PROFESSOR")
//            .anyRequest().authenticated()
//            );
//        return http.build();
//    }
//}
