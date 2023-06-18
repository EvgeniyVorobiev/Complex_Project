package com.complex_project.balanced_nutrition;

import com.complex_project.balanced_nutrition.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
@RestController
public class BalancedNutritionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalancedNutritionApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(authorize -> authorize
						.anyRequest().permitAll()
				)
				.formLogin(withDefaults())
				.httpBasic(withDefaults())
				//.anonymous(AbstractHttpConfigurer::disable)         // AnonymousAuthenticationFilter
				.csrf(AbstractHttpConfigurer::disable)    ;          // CsrfFilter
//				.sessionManagement(AbstractHttpConfigurer::disable) // DisableEncodeUrlFilter, SessionManagementFilter
//				.exceptionHandling(AbstractHttpConfigurer::disable) // ExceptionTranslationFilter
//				.headers(AbstractHttpConfigurer::disable)           // HeaderWriterFilter
//				.logout(AbstractHttpConfigurer::disable)            // LogoutFilter
//				.requestCache(AbstractHttpConfigurer::disable)      // RequestCacheAwareFilter
//				.servletApi(AbstractHttpConfigurer::disable)        // SecurityContextHolderAwareRequestFilter
//				.securityContext(AbstractHttpConfigurer::disable);
		return http.build();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:8081")
						.allowedMethods("*");
			}
		};
	}
}
