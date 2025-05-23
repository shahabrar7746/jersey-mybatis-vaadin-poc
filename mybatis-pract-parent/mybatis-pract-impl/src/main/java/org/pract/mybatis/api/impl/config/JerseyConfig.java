package org.pract.mybatis.api.impl.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.pract.mybatis.api.impl.serviceimpl.ProductServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig  extends ResourceConfig {
    JerseyConfig()
    {
        register(ProductServiceImpl.class);
    }
}
