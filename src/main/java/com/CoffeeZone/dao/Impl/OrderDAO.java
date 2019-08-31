package com.CoffeeZone.dao.Impl;

import com.CoffeeZone.dao.IOrderDAO;
import com.CoffeeZone.entity.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository(value = "orderDAO")
@Transactional(rollbackFor = SQLException.class)
public class OrderDAO implements IOrderDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MSSQL");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public ArrayList<OrderEntity> findAll(){
        return (ArrayList<OrderEntity>)
                entityManager.createQuery("select o from OrderEntity o ORDER BY o.status ASC ",OrderEntity.class).getResultList();
    }
    @Override
    public ArrayList<OrderEntity> findByStatus(){
        ArrayList orders = (ArrayList)
                entityManager.createQuery("SELECT o from  OrderEntity o where o.status=false ").getResultList();
        return orders;
    }
    @Override
    public OrderEntity update(OrderEntity order){
        entityManager.getTransaction().begin();
        entityManager.merge(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
    @Override
    public OrderEntity findById(Integer id){
        return entityManager.find(OrderEntity.class,id);
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(orderEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return orderEntity;
    }

}
