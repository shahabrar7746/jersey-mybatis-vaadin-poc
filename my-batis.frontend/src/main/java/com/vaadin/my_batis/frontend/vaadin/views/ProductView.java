package com.vaadin.my_batis.frontend.vaadin.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
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
    private Button deleteButton;
    private Grid<ProductDto> productGrid = new Grid<>(ProductDto.class, false);
    private GridListDataView<ProductDto> productListGrid;

    public ProductView(ProductPresenter presenter) {
        this.presenter = presenter;
        presenter.setView(this);
        init();
    }

    @Override
    public void init() {
        addDeleteButton();
        display();
        deleteSelectionEventHandler();

    }

    private void display() {
        final var productDtos = presenter.fetchAll(new ProductFilter());
        productListGrid = productGrid.setItems(productDtos);
        productGrid.addColumn(ProductDto::getProductName).setHeader("Product Name");
        productGrid.addColumn(ProductDto::getSeller).setHeader("Seller Name");
        add(productGrid);
    }
    private void addDeleteButton()
    {
        deleteButton = new Button("Delete Product");
        deleteButton.setEnabled(false);
        add(deleteButton);
    }
    private void deleteSelectionEventHandler()
    {

        productGrid.addSelectionListener(selectionEvent ->{
            deleteButton.getStyle()
                    .setBackgroundColor("#1E90FF")
                    .set("color", "#FFFFFF");
            deleteButton.setEnabled(true);
            deleteButtonListener(selectionEvent.getFirstSelectedItem().get());
        });
    }
    private void deleteButtonListener(ProductDto dto)
    {

       deleteButton.addClickListener(event ->{
           Notification deleteNotification = null;
           boolean deleted = presenter.deleteProduct(dto);
           if (deleted)
           {
               deleteNotification = Notification.show("Product deleted",2000, Notification.Position.BOTTOM_CENTER);
               deleteButton.setEnabled(false);
               productListGrid.removeItem(dto);
               productListGrid.refreshAll();
               deleteButton.getStyle()
                       .clear();
           }else{
               deleteNotification = Notification.show("Product not deleted", 2000, Notification.Position.BOTTOM_CENTER);
           }
         add(deleteNotification);
           deleteNotification.setAssertive(false);
       });

    }
}
