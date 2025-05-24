package org.pract.mybatis.api.service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.springframework.http.MediaType;

import java.util.List;

@Path("sellers")
public interface SellerService {

    @GET
    List<String> findAllSellerName();
}
