package org.pract.mybatis.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String productName;


    private String seller;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
