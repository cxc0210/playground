package com.cxc.playground.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {
    private Integer connectionTimeout = -1;

    private Integer readTimeout = -1;

    @Bean
    public RestTemplate registerTemplate() {
        RestTemplate restTemplate = new RestTemplate(getFactory());
        restTemplate.getMessageConverters().add(getConverter());
        return restTemplate;
    }

    private SimpleClientHttpRequestFactory getFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }

    private MappingJackson2HttpMessageConverter getConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> MediaTypes = new ArrayList<>();
        MediaTypes.add(MediaType.TEXT_PLAIN);
        MediaTypes.add(MediaType.TEXT_HTML);
        converter.setSupportedMediaTypes(MediaTypes);
        return converter;
    }
}
