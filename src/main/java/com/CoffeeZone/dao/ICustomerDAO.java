package com.CoffeeZone.dao;

import com.CoffeeZone.entity.CustomerEntity;

public interface ICustomerDAO extends GenericDAO<CustomerEntity> {
    CustomerEntity findByEmail(String email);
}
