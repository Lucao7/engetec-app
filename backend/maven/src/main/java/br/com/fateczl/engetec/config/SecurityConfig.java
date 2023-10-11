package br.com.fateczl.engetec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
//            .authorizeHttpRequests(
//            		(authz) -> authz
//            		.requestMatchers("/aluno/registrar-se").permitAll()
////            		.requestMatchers("/avaliador/resgistrar-se").permitAll()
//            		.requestMatchers("/aluno/**").hasRole("ALUNO")
//            		.requestMatchers("/avaliador/**").hasRole("PROFESSOR")
//            		.anyRequest().authenticated()
//            );
            //.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize
        		.requestMatchers(HttpMethod.POST, "/aluno").permitAll()
        		.requestMatchers(HttpMethod.DELETE, "/aluno").hasRole("ALUNO")
        		.anyRequest().authenticated()
        		)
        .build();
    }
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throw Exception{
//		
//	}
//	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests((authz) -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(withDefaults());
//    }
//}

//package br.com.fateczl.engetec.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class SecurityConf {
//
//	public SecurityFilterChain filterChain(HttpSecurity http) {
//		http
//	    .authorizeHttpRequests((authorize) -> authorize
//	        .anyRequest().authenticated()
//	    ).
//			.formLogin(form -> form
//				.loginPage("/login")
//				.permitAll()
//			);
//		// ...
//	}
//	
//	@Bean
//	SecurityFilterChain web(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((authorize) -> authorize
//				.requestMatchers("/endpoint").hasAuthority('USER')
//				.anyRequest().authenticated()
//			)
//	        // ...
//
//		return http.build();
//	}
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
