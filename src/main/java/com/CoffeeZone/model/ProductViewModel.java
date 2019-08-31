package com.CoffeeZone.model;

import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.entity.ProductEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ProductViewModel implements Serializable{

    private Integer id;

    private String name;

    private String description;

    private Integer status;

    private Integer quantity;

    private String flavor;

    private String weight;

    private Integer price;

    private String image;

    private Integer brandEntity;
    private MultipartFile multipartFile;

    public Integer getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(Integer brandEntity) {
        this.brandEntity = brandEntity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }



    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
