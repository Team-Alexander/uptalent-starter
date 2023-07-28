package io.github.uptalent.starter.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.github.uptalent.starter.util.Constants.USER_ID_KEY;
import static io.github.uptalent.starter.util.Constants.USER_ROLE_KEY;

@Configuration
public class FeignConfig {

    private final HttpServletRequest request;

    @Autowired
    public FeignConfig(HttpServletRequest request) {
        this.request = request;
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String userId = request.getHeader(USER_ID_KEY);
            String userRole = request.getHeader(USER_ROLE_KEY);
            if (userId != null) requestTemplate.header(USER_ID_KEY, userId);
            if (userRole != null) requestTemplate.header(USER_ROLE_KEY, userRole);
        };
    }
}