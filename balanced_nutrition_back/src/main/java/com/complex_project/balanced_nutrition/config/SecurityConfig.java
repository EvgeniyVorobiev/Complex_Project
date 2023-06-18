package com.complex_project.balanced_nutrition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration implements WebMvcConfigurer {

    public class SecurityFilterChainImpl {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            return http
                    .anonymous(AbstractHttpConfigurer::disable)         // AnonymousAuthenticationFilter
                    .csrf(AbstractHttpConfigurer::disable)              // CsrfFilter
                    .sessionManagement(AbstractHttpConfigurer::disable) // DisableEncodeUrlFilter, SessionManagementFilter
                    .exceptionHandling(AbstractHttpConfigurer::disable) // ExceptionTranslationFilter
                    .headers(AbstractHttpConfigurer::disable)           // HeaderWriterFilter
                    .logout(AbstractHttpConfigurer::disable)            // LogoutFilter
                    .requestCache(AbstractHttpConfigurer::disable)      // RequestCacheAwareFilter
                    .servletApi(AbstractHttpConfigurer::disable)        // SecurityContextHolderAwareRequestFilter
                    .securityContext(AbstractHttpConfigurer::disable)   // SecurityContextPersistenceFilter
                    .authorizeRequests(auth -> auth.requestMatchers("/**").permitAll())
                    .build();
        }
    }
}
