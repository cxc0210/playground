package com.cxc.playground.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customResponseInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public CustomResponseInterceptor customResponseInterceptor() {
        return new CustomResponseInterceptor();
    }
}
