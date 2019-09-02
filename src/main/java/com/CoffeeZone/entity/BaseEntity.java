package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    @Column(name = "created_date")
    private Timestamp createdDate;

  //  @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    //@LastModifiedBy
    @Column(name="modified_by")
    private String modifiedBy;

    public Integer getId() {
        return id;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
