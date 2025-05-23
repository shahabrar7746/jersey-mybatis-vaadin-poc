package org.pract.mybatis.api.service;

import jakarta.ws.rs.*;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.springframework.http.MediaType;

import java.util.List;

@Path("products")
@Consumes({MediaType.APPLICATION_JSON_VALUE})
@Produces({MediaType.APPLICATION_JSON_VALUE})
public interface ProductService {

    @GET
    List<ProductDto> findAll(@BeanParam ProductFilter filter);

}
