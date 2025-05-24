package com.vaadin.my_batis.frontend.vaadin.presenters;

import com.vaadin.my_batis.frontend.vaadin.structure.abstarctstructure.AbstractPresenter;
import com.vaadin.my_batis.frontend.vaadin.views.ProductView;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;
import org.pract.mybatis.api.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.management.Notification;
import java.util.List;
@Component
@Scope("prototype")
public class ProductPresenter extends AbstractPresenter<ProductView> {
    private ProductView view;
    private final ProductService service;
    public ProductPresenter(ProductService service) {
        this.service = service;
    }

    @Override
    public void setView(ProductView view) {
        this.view = view;
    }

    public List<ProductDto> fetchAll(ProductFilter filter)
    {
        if(! filter.isEnable())
        {
            filter.setJoin(true);
        }
       return service.findAll(filter);
    }

    public boolean deleteProduct(ProductDto dto)
    {
        return service.remove(dto.getId());
    }
}
