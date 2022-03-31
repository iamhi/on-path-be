package com.github.iamhi.onpath.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

//@Configuration
public class WebConfig {

//    @Bean
    CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfig = new CorsConfiguration();

        corsConfig.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfig.setMaxAge(8000L);
        corsConfig.addAllowedMethod(HttpMethod.GET);
        corsConfig.addAllowedMethod(HttpMethod.POST);
        corsConfig.addAllowedHeader("Content-Type");
        corsConfig.addAllowedHeader("Accept");
        corsConfig.addAllowedHeader("usercode");
        corsConfig.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
