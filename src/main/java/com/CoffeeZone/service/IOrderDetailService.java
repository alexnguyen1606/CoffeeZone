package com.CoffeeZone.service;

import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.service.Impl.OrderDetailService;

import java.util.ArrayList;

public interface IOrderDetailService extends GenericService<OrderDetailEntity> {
    ArrayList<OrderDetailEntity> findByStatus();
    ArrayList<OrderDetailEntity> findByOrderId(Integer id);
}
