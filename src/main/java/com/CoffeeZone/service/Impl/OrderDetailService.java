package com.CoffeeZone.service.Impl;


import com.CoffeeZone.dao.Impl.OrderDetailDAO;
import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderDetailService implements IOrderDetailService{
    @Autowired
    private OrderDetailDAO orderDetailDAO;
    @Autowired
    private OrderService orderService;

    @Override
    public ArrayList<OrderDetailEntity> findAll() {
        return null;
    }
    @Override
    public OrderDetailEntity save(OrderDetailEntity orderDetail){
        return orderDetailDAO.save(orderDetail);
    }
    @Override
    public ArrayList<OrderDetailEntity> findByOrderId(Integer id){
        OrderEntity order = orderService.findById(id);
        return orderDetailDAO.findByOrderId(order);
    }
    @Override
    public OrderDetailEntity update(OrderDetailEntity orderDetail){
        return orderDetailDAO.update(orderDetail);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public OrderDetailEntity findById(Integer id) {
        return null;
    }
    @Override
    public ArrayList<OrderDetailEntity> findByStatus(){
        return orderDetailDAO.findByStatus();
    }
}
