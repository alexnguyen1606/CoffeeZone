package com.CoffeeZone.dao;

import com.CoffeeZone.entity.ProductEntity;

import java.util.ArrayList;

public interface IProductDAO extends GenericDAO<ProductEntity> {

    ArrayList<ProductEntity> findByStatus();
}
