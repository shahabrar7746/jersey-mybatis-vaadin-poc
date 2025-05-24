package org.pract.mybatis.api.impl.repository;

import org.pract.mybatis.api.impl.models.ProductModel;

public interface ProductModificationRepository {

    boolean delete(Integer productId);

    void save(ProductModel entity);

}
