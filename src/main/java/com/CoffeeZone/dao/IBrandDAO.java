package com.CoffeeZone.dao;

import com.CoffeeZone.entity.BrandEntity;

import java.util.ArrayList;

public interface IBrandDAO extends GenericDAO<BrandEntity> {

    ArrayList<BrandEntity> findByStatus();
}
