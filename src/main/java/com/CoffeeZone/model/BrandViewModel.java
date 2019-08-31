package com.CoffeeZone.model;

public class BrandViewModel {

    private Integer id;

    private String name;

    private String description;

    private Boolean status;

    private Integer establieshed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getEstablieshed() {
        return establieshed;
    }

    public void setEstablieshed(Integer establieshed) {
        this.establieshed = establieshed;
    }
}
