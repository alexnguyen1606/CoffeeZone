package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Table(name = "OderDetail")
@Entity
public class OrderDetailEntity extends BaseEntity implements Serializable {

    @Column(name = "Quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ProductId",nullable = false)
    private ProductEntity product;
    @ManyToOne()
    @JoinColumn(name = "OderId",nullable = false)
    private OrderEntity order;

    @Column(name = "Status")
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
