package org.pract.mybatis.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SellerDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
