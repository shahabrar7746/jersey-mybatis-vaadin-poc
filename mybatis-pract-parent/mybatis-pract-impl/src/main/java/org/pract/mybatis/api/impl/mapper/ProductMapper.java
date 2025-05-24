package org.pract.mybatis.api.impl.mapper;

import jakarta.validation.constraints.NotNull;

import org.apache.ibatis.annotations.Mapper;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.pract.mybatis.api.impl.models.ProductModel;
import org.pract.mybatis.api.impl.repository.ProductModificationRepository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {


    List<ProductDto> findAll(ProductFilter filter);


}
