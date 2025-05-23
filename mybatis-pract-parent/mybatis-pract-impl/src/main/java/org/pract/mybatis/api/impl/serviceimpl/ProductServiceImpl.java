package org.pract.mybatis.api.impl.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.dto.SellerDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.pract.mybatis.api.impl.mapper.ProductMapper;
import org.pract.mybatis.api.impl.mapper.SellerMapper;
import org.pract.mybatis.api.impl.models.ProductModel;
import org.pract.mybatis.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component

public class ProductServiceImpl implements ProductService {

    private final ProductMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductMapper mapper, SellerMapper sellerMapper) {
        this.mapper = mapper;
        this.sellerMapper = sellerMapper;
    }

    private final SellerMapper sellerMapper;

    @Override
    public List<ProductDto> findAll(ProductFilter filter) {
        List<ProductModel> models = null;
        models = mapper.findAll(filter);
        List<Integer> sellerIds = models.stream()
                .map(ProductModel::getSeller).collect(Collectors.toList());
        return convertToProductDto(models, sellerIds);
    }

    private List<ProductDto> convertToProductDto(List<ProductModel> models, List<Integer> sellerId) {
        return models
                .stream()
                .map(productModel -> {
                    ProductDto dto = new ProductDto();
                    dto.setId(productModel.getId());
                    dto.setProductName(productModel.getName());
                    final var sellerNameById = sellerMapper.toDto(sellerId.removeFirst());
                    dto.setSeller(sellerNameById);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
