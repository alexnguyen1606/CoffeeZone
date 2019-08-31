package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IImageDAO;
import com.CoffeeZone.entity.ImageEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository(value = "imageDAO")
@Transactional(rollbackFor = SQLException.class)
public class ImageDAO implements IImageDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public ArrayList<ImageEntity> findAll() {
        return null;
    }

    @Override
    public ImageEntity findById(Integer id) {
        return null;
    }

    public ImageEntity save(ImageEntity imageEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(imageEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return imageEntity;
    }

    @Override
    public ImageEntity update(ImageEntity imageEntity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
