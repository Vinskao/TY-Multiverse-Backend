package tw.com.tymbackend.core.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:4321","https://peoplesystem.tatdvsonorth.com/tymultiverse/"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");  // Allow GET method
        config.addAllowedMethod("POST"); // Allow POST method
        config.addAllowedMethod("OPTIONS"); // Explicitly allow OPTIONS method for preflight requests

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
