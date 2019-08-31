package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.ImageDAO;
import com.CoffeeZone.entity.ImageEntity;
import com.CoffeeZone.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImageService implements IImageService{
    @Autowired
    private ImageDAO imageDAO;

    @Override
    public ArrayList<ImageEntity> findAll() {
        return null;
    }
    @Override
    public ImageEntity save(ImageEntity imageEntity){
        return imageDAO.save(imageEntity);
    }

    @Override
    public ImageEntity update(ImageEntity imageEntity) {
        return imageDAO.update(imageEntity);
    }

    @Override
    public void deleteById(Integer id) {
        imageDAO.deleteById(id);
    }

    @Override
    public ImageEntity findById(Integer id) {
        return imageDAO.findById(id);
    }
}
