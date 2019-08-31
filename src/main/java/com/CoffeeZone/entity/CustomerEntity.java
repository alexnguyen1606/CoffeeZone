package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Table(name = "Customer")
@Entity
public class CustomerEntity extends BaseEntity implements Serializable {

    @Column(name = "Name")
    private String name;
    @Column(name = "City")
    private String city;
    @Column(name = "District")
    private String district;
    @Column(name = "ward")
    private String ward;
    @Column(name = "Street")
    private String street;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "Email")
    private String email;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<OrderEntity> listOder = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrderEntity> getListOder() {
        return listOder;
    }

    public void setListOder(Set<OrderEntity> listOder) {
        this.listOder = listOder;
    }
}
