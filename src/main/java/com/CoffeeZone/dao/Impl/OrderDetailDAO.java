package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IOrderDetailDAO;
import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.entity.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository(value = "orderDetailDAO")
@Transactional(rollbackFor = SQLException.class)
public class OrderDetailDAO implements IOrderDetailDAO{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    public  ArrayList<OrderDetailEntity> findByStatus(){
        return (ArrayList<OrderDetailEntity>)
                entityManager.createQuery("select o from OrderDetailEntity o where o.status=true ").getResultList();
    }
    public ArrayList<OrderDetailEntity> findByOrderId(OrderEntity order){
        ArrayList<OrderDetailEntity> order1= (ArrayList<OrderDetailEntity>)
                entityManager.createQuery("select od from OrderDetailEntity od where od.order=:order")
                .setParameter("order",order).getResultList();
        return order1;
    }

    @Override
    public ArrayList<OrderDetailEntity> findAll() {
        return (ArrayList<OrderDetailEntity>) entityManager.createQuery("SELECT od from OrderDetailEntity od").getResultList();
    }

    @Override
    public OrderDetailEntity findById(Integer id) {
        return entityManager.find(OrderDetailEntity.class,id);
    }

    @Override
    public OrderDetailEntity save(OrderDetailEntity orderDetail) {
        entityManager.getTransaction().begin();
        entityManager.persist(orderDetail);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return orderDetail;
    }

    public OrderDetailEntity update(OrderDetailEntity orderDetail){
        entityManager.getTransaction().begin();
        entityManager.merge(orderDetail);
        entityManager.getTransaction().commit();
        return orderDetail;
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}
