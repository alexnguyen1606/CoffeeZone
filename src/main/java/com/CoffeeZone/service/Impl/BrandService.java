package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.BrandDAO;
import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandDAO brandDAO;

    public ArrayList<BrandEntity> findAll(){
        return brandDAO.findAll();
    }
    public BrandEntity save(BrandEntity brand){
        return brandDAO.save(brand);
    }
    public BrandEntity update(BrandEntity brand){
        return brandDAO.update(brand);
    }
    public BrandEntity findById(Integer id){
        return brandDAO.findById(id);
    }
    @Override
    public void deleteById(Integer id) {
        brandDAO.delete(id);
    }
}
