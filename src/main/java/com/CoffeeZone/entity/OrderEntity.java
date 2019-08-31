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

@Table(name = "Oder")
@Entity
public class OrderEntity extends BaseEntity implements Serializable {

    @Column(name = "TotalMoney")
    private Integer totalMoney;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetailEntity> listOderDetail = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "CustomerId",nullable = false)
    private CustomerEntity customer;


    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
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

    public List<OrderDetailEntity> getListOderDetail() {
        return listOderDetail;
    }

    public void setListOderDetail(List<OrderDetailEntity> listOderDetail) {
        this.listOderDetail = listOderDetail;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}
