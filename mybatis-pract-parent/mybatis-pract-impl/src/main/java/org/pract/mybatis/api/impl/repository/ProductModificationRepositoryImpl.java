package org.pract.mybatis.api.impl.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.pract.mybatis.api.impl.models.ProductModel;
import org.pract.mybatis.api.impl.models.ProductModel_;
import org.springframework.stereotype.Component;

@Component
public class ProductModificationRepositoryImpl implements ProductModificationRepository{

    private final EntityManager manager;

    public ProductModificationRepositoryImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    @Transactional
    public boolean delete(Integer productId) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaDelete<ProductModel> criteriaDelete = builder.createCriteriaDelete(ProductModel.class);
        Root<ProductModel> modelRoot = criteriaDelete.from(ProductModel.class);
        Predicate condition = builder.equal(modelRoot.get(ProductModel_.ID), productId);
        criteriaDelete.where(builder.equal(modelRoot.get(ProductModel_.ID), productId));
        int rowsChanged = manager.createQuery(criteriaDelete).executeUpdate();
        return rowsChanged> 0;
    }

    @Override
    @Transactional
    public void save(ProductModel entity) {
        manager.persist(entity);
    }
}
