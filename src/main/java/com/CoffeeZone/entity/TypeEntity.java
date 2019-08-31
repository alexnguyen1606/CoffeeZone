package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Type")
public class TypeEntity extends BaseEntity implements Serializable {

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "TypeProduct",joinColumns = {@JoinColumn(name = "TypeId")},
    inverseJoinColumns = {@JoinColumn(name = "ProductId")})
    private Set<ProductEntity> listProduct = new HashSet<>();


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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<ProductEntity> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Set<ProductEntity> listProduct) {
        this.listProduct = listProduct;
    }
}
