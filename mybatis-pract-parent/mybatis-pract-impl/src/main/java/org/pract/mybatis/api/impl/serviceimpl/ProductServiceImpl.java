package org.pract.mybatis.api.impl.serviceimpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.dto.SellerDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.pract.mybatis.api.impl.mapper.ProductMapper;
import org.pract.mybatis.api.impl.mapper.SellerMapper;
import org.pract.mybatis.api.impl.models.ProductModel;
import org.pract.mybatis.api.impl.repository.ProductModificationRepository;
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

    private final ProductModificationRepository modifyRepo;

    private final SellerMapper sellerMapper;

    public ProductServiceImpl(ProductMapper mapper, ProductModificationRepository modifyRepo, SellerMapper sellerMapper) {
        this.mapper = mapper;
        this.modifyRepo = modifyRepo;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public List<ProductDto> findAll(ProductFilter filter) {
        return mapper.findAll(filter);
    }

    @Override
    public Boolean addProduct(ProductDto productDto) {
        try {
            ProductModel model = new ProductModel();
            model.setSeller(sellerMapper.findByName(productDto.getSeller()));
            model.setName(productDto.getProductName());
            modifyRepo.save(model);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean remove(@NonNull Integer id) {
        return modifyRepo.delete(id);
    }

}
