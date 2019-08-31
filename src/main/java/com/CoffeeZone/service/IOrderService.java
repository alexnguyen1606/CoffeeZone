package com.CoffeeZone.service;

import com.CoffeeZone.entity.OrderEntity;

import java.util.ArrayList;

public interface IOrderService extends GenericService<OrderEntity> {
    ArrayList<OrderEntity> findByStatus();
}
