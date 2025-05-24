package org.pract.mybatis.api.impl.serviceimpl;

import org.pract.mybatis.api.impl.mapper.SellerMapper;
import org.pract.mybatis.api.service.SellerService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SellerServiceImpl implements SellerService {

    private final SellerMapper mapper;

    public SellerServiceImpl(SellerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<String> findAllSellerName() {
        return mapper.findAllSellerName();
    }
}
