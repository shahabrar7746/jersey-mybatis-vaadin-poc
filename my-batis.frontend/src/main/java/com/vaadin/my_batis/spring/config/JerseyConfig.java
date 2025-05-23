package com.vaadin.my_batis.spring.config;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

import jakarta.ws.rs.client.WebTarget;
import org.apache.catalina.WebResource;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.loader.WebappClassLoader;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.pract.mybatis.api.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

import static org.glassfish.jersey.client.proxy.WebResourceFactory.newResource;

@Configuration
public class JerseyConfig {

    @Value("${jersey.server.url}")
    private String JERSEY_URL;

    @Bean
    public ProductService getProductService()
    {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(JERSEY_URL);
        return WebResourceFactory.newResource(ProductService.class, target);
    }



}
