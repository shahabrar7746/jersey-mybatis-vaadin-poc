package org.pract.mybatis.api.service;

import jakarta.ws.rs.*;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Path("products")
@Consumes({MediaType.APPLICATION_JSON_VALUE})
@Produces({MediaType.APPLICATION_JSON_VALUE})
public interface ProductService {

    @GET
    List<ProductDto> findAll(@BeanParam ProductFilter filter);

     @POST
     Boolean addProduct(ProductDto productDto);

    @DELETE
    Boolean remove(@QueryParam("id") Integer id);


}
