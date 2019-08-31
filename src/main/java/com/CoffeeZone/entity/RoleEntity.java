package com.CoffeeZone.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Roles")
public class RoleEntity extends BaseEntity implements Serializable {

    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "AccoutRole",joinColumns = {@JoinColumn(name = "RoleId")},
            inverseJoinColumns = {@JoinColumn(name = "AccountId")}
    )
    private Set<AccountEntity> accountEntities = new HashSet<>();

    public Set<AccountEntity> getAccountEntities() {
        return accountEntities;
    }

    public void setAccountEntities(Set<AccountEntity> accountEntities) {
        this.accountEntities = accountEntities;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
