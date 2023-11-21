package br.com.fateczl.engetec.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.fateczl.engetec.security.JWTAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	SecurityFilter securityFilter;
	
	@Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
//		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//        .and()
		.csrf(csrf -> csrf.disable())
        .cors(Customizer.withDefaults())
//        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize
        		.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
        		.requestMatchers(HttpMethod.POST, "/aluno").permitAll()
        		.requestMatchers(HttpMethod.GET, "/aluno").permitAll()
        		.requestMatchers(HttpMethod.POST, "/avaliador").permitAll()
        		.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", 
        				"/swagger-ui.html", "/swagger-ui/**", 
        				"/swagger-resources/**", "/webjars/**").permitAll()		
        		.requestMatchers(HttpMethod.DELETE, "/aluno").hasRole("ALUNO")
        		.anyRequest().authenticated()
        		)
        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
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
