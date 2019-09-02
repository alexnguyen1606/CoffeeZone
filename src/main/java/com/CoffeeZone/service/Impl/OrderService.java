package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.OrderDAO;
import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderDAO orderDAO;
    @Override
    public OrderEntity save(OrderEntity orderEntity){
        return orderDAO.save(orderEntity);
    }
    @Override
    public ArrayList<OrderEntity> findByStatus(){
        return orderDAO.findByStatus();
    }
    @Override
    public OrderEntity findById(Integer id){
        return orderDAO.findById(id);
    }
    @Override
    public ArrayList<OrderEntity> findAll(){
        return orderDAO.findAll();
    }
    @Override
    public OrderEntity update(OrderEntity order)
    {
        return orderDAO.update(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderDAO.deleteById(id);
    }

}
