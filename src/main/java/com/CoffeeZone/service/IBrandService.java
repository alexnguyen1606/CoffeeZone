package com.CoffeeZone.service;

import com.CoffeeZone.entity.BrandEntity;

import java.util.ArrayList;

public interface IBrandService  extends  GenericService<BrandEntity>{
    void saveAll(ArrayList<BrandEntity> brands,String createdBy);
}
