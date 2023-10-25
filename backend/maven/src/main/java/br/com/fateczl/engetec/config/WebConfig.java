//package br.com.fateczl.engetec.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//			.allowedOrigins("http://localhost:4200")
//			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
//			.allowCredentials(true);
//	}
//}

//@Configuration
//public class WebConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        // Configurar as origens permitidas (pode ser "*", mas é recomendado especificar as origens)
//        config.addAllowedOrigin("http://localhost:4200");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("DELETE");
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}


