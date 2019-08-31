package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Picture")
public class ImageEntity extends BaseEntity implements Serializable {

    @Column(name = "Href")
    private String href;
    @Column(name = "Status")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "ProductId",nullable = false)
    private ProductEntity product;


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
