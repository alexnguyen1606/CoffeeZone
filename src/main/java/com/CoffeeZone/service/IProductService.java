package com.CoffeeZone.service;

import com.CoffeeZone.entity.ProductEntity;

import java.util.ArrayList;

public interface IProductService extends GenericService<ProductEntity>{
    ArrayList<ProductEntity> findByStatus();
    void saveAll(ArrayList<ProductEntity> products,String createdBy);
}
