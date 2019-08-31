package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.ICustomerDAO;
import com.CoffeeZone.entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository(value = "customerDAO")
@Transactional(rollbackFor = SQLException.class)
public class CustomerDAO implements ICustomerDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public ArrayList<CustomerEntity> findAll() {
        return (ArrayList<CustomerEntity>) entityManager.createQuery("select c from CustomerEntity c").getResultList();
    }
    @Override
    public CustomerEntity findById(Integer id){
        return entityManager.find(CustomerEntity.class,id);
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(customerEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return customerEntity;
    }

    @Override
    public CustomerEntity update(CustomerEntity customerEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(customerEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return customerEntity;
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
    @Override
    public CustomerEntity findByEmail(String email){
        CustomerEntity customerEntity =
                entityManager.createQuery("select c from CustomerEntity c where c.email=:email",CustomerEntity.class)
                .setParameter("email",email).getSingleResult();
        return customerEntity;
    }
}
