package com.CoffeeZone.dao;

import com.CoffeeZone.entity.OrderEntity;

import java.util.ArrayList;

public interface IOrderDAO extends GenericDAO<OrderEntity> {

    ArrayList<OrderEntity> findByStatus();
}
