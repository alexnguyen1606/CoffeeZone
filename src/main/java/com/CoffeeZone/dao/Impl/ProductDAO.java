package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IProductDAO;
import com.CoffeeZone.entity.ProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository(value = "productDAO")
@Transactional(rollbackFor = SQLException.class)
public class ProductDAO implements IProductDAO{
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public ArrayList<ProductEntity> findAll(){
        return (ArrayList<ProductEntity>) entityManager.createQuery
                ("select p From ProductEntity p ",ProductEntity.class).getResultList();
    }@Override
    public ArrayList<ProductEntity> findByStatus(){
        return (ArrayList<ProductEntity>) entityManager.createQuery
                ("select p From ProductEntity p where p.status=1",ProductEntity.class).getResultList();
    }
    @Override
    public ProductEntity findById(Integer id){
        ProductEntity entity = entityManager.find(ProductEntity.class,id);
        return   entity;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(productEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return productEntity;
    }



    @Override
    public void deleteById(Integer id) {
        ProductEntity productEntity = findById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(productEntity);
        entityManager.getTransaction().commit();
    }
    @Override
      public ProductEntity update(ProductEntity productEntity){
        entityManager.getTransaction().begin();
        entityManager.merge(productEntity);
        entityManager.getTransaction().commit();
        return productEntity;
    }

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
