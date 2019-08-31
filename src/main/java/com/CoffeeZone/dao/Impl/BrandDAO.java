package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IBrandDAO;
import com.CoffeeZone.entity.BrandEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

@Repository(value = "brandDAO")
@Transactional(rollbackFor = Exception.class)
public class BrandDAO implements IBrandDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public BrandEntity findById(Integer id){
        return entityManager.find(BrandEntity.class,id);
    }
    public ArrayList<BrandEntity> findAll(){
        return (ArrayList<BrandEntity>) entityManager.createQuery("SELECT b from BrandEntity b").getResultList();
    }
    public BrandEntity save(BrandEntity brand){
        entityManager.getTransaction().begin();
        entityManager.persist(brand);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return brand;
    }
    public BrandEntity update(BrandEntity brandEntity){
        entityManager.getTransaction().begin();
        entityManager.merge(brandEntity);
        entityManager.getTransaction().commit();
        return brandEntity;
    }

    @Override
    public void deleteById(Integer id) {
        BrandEntity brand = findById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(brand);
        entityManager.getTransaction().commit();
    }

    public void delete(Integer id){
        BrandEntity brand = findById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(brand);
        entityManager.getTransaction().commit();
    }
    public ArrayList<BrandEntity> findByStatus(){
        return (ArrayList<BrandEntity>)
                entityManager.createQuery("select b from BrandEntity b where b.status").getResultList();
    }
}
