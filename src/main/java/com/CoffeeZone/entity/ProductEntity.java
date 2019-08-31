package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Product")
@Entity
public class ProductEntity extends BaseEntity {

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Integer status;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "Flavor")
    private String flavor;
    @Column(name = "Weight")
    private String weight;
    @Column(name = "Prices")
    private Integer price;
    @Column(name = "Image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private BrandEntity brandEntity;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<ImageEntity> listImage = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private Set<OrderDetailEntity> listOderDetail = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "TypeProduct",joinColumns = {@JoinColumn(name = "ProductId")},
    inverseJoinColumns = {@JoinColumn(name = "TypeId")})
    private Set<TypeEntity> listType = new HashSet<>();


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

    public BrandEntity getBrandEntity() {
        return brandEntity;
    }

    public void setBrandEntity(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
    }

    public List<ImageEntity> getListImage() {
        return listImage;
    }

    public void setListImage(List<ImageEntity> listImage) {
        this.listImage = listImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<OrderDetailEntity> getListOderDetail() {
        return listOderDetail;
    }

    public void setListOderDetail(Set<OrderDetailEntity> listOderDetail) {
        this.listOderDetail = listOderDetail;
    }

    public Set<TypeEntity> getListType() {
        return listType;
    }

    public void setListType(Set<TypeEntity> listType) {
        this.listType = listType;
    }
}
