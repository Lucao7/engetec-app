//package br.com.fateczl.engetec.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(
//            		(authz) -> authz
//            		.requestMatchers("/aluno/**").hasRole("ALUNO")
//            		.requestMatchers("/professor/**").hasRole("PROFESSOR")
//            		.requestMatchers("/comite/**").hasRole("COMITE")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//            ).
//            .httpBasic(withDefaults());
//        return http.build();
//    }
//	
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////            .authorizeHttpRequests((authz) -> authz
////                .anyRequest().authenticated()
////            )
////            .httpBasic(withDefaults());
////    }
//}
