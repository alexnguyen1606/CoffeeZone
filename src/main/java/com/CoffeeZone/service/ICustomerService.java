package com.CoffeeZone.service;

import com.CoffeeZone.entity.CustomerEntity;

public interface ICustomerService extends GenericService<CustomerEntity>{
    CustomerEntity findByEmail(String email);
}
