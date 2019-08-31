package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Brand")
public class BrandEntity  extends BaseEntity implements Serializable {
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @Column(name = "Established")
    private Integer establieshed;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brandEntity")
    private Set<ProductEntity> listProduct = new HashSet<>();


    public Integer getEstablieshed() {
        return establieshed;
    }

    public void setEstablieshed(Integer establieshed) {
        this.establieshed = establieshed;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Set<ProductEntity> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<ProductEntity> listProduct) {
        this.listProduct = listProduct;
    }
}
