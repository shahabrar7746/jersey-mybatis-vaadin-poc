package com.vaadin.my_batis.frontend.vaadin.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.my_batis.frontend.vaadin.presenters.ProductPresenter;
import com.vaadin.my_batis.frontend.vaadin.structure.abstarctstructure.AbstractView;
import org.pract.mybatis.api.dto.ProductDto;
import org.pract.mybatis.api.filters.ProductFilter;

import java.util.List;

@Route("/")
public class ProductView extends AbstractView<ProductPresenter> {
    private final ProductPresenter presenter;

    private Grid<ProductDto> productGrid = new Grid<>(ProductDto.class);
    private GridListDataView<ProductDto> productListGrid;

    public ProductView(ProductPresenter presenter) {
        this.presenter = presenter;
        presenter.setView(this);
        init();
    }

    @Override
    public void init() {
        display();
    }

    private void display() {
        final var productDtos = presenter.fetchAll(new ProductFilter());
        productGrid.setItems(productDtos);

      //  productGrid.addColumn(ProductDto::getProductName).setHeader("Product Name");
        add(new H2("Hiiiiiii"));
        add(productGrid);
    }
}
