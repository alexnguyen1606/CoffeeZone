package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.ProductDAO;
import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {


    @Autowired
    private ProductDAO productDAO;
    @Override
    public ProductEntity save(ProductEntity productEntity){
        return productDAO.save(productEntity);
    }
    @Override
    public ArrayList<ProductEntity> findByStatus(){
        return (ArrayList<ProductEntity>) productDAO.findByStatus();
    }

    @Override
    public void saveAll(ArrayList<ProductEntity> products,String createdBy) {
        for(ProductEntity product: products){
            product.setCreatedBy(createdBy);
            productDAO.save(product);
        }
    }

    public ArrayList<ProductEntity> findAll(){
        return productDAO.findAll();
    }
    @Override
    public ProductEntity findById(Integer id)
    {
        return productDAO.findById(id);
    }
    @Override
    public ProductEntity update(ProductEntity productEntity){
        return productDAO.update(productEntity);
    }

    @Override
    public void deleteById(Integer id) {
        productDAO.deleteById(id);
    }

}
