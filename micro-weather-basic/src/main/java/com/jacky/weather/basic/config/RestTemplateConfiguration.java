package com.jacky.weather.basic.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author Jacky
 * Date:   2018/12/25
 * Time:   2:07
 */
@Configuration
public class RestTemplateConfiguration {

    @Autowired
    RestTemplateBuilder builder; // use Apache HttpClient to create the RestTemplate for solving GZIP's decoding problem.

    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().add(jacksonSupportsMoreTypes());
        return restTemplate;
    }


    private HttpMessageConverter jacksonSupportsMoreTypes() {//eg. Gitlab returns JSON as plain text
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.parseMediaType("text/plain;charset=utf-8"), MediaType.APPLICATION_OCTET_STREAM));
        return converter;
    }
}
