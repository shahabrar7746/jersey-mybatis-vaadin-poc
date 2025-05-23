package org.pract.mybatis.api.filters;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductFilter {
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<String> getSellerNames() {
        return sellerNames;
    }

    public void setSellerNames(List<String> sellerNames) {
        this.sellerNames = sellerNames;
    }

    public Boolean getJoin() {
        return join;
    }

    public void setJoin(Boolean join) {
        this.join = join;
    }

    @QueryParam("id")
    private List<Integer> ids;

    @QueryParam("product-name")
    private List<String> productNames;

    @QueryParam("seller-name")
    private List<String> sellerNames;

    @QueryParam("join")
    private Boolean join;

    public boolean isEnable() {
        return (ids != null && !ids.isEmpty())
                || (productNames != null && !productNames.isEmpty())
                || (sellerNames != null && !sellerNames.isEmpty())
                || (join != null && join);
    }
}
