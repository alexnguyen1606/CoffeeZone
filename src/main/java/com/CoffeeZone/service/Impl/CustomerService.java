package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.CustomerDAO;
import com.CoffeeZone.entity.CustomerEntity;
import com.CoffeeZone.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public ArrayList<CustomerEntity> findAll() {
        return customerDAO.findAll();
    }

    public CustomerEntity save(CustomerEntity customerEntity){
        return customerDAO.save(customerEntity);
    }

    @Override
    public CustomerEntity update(CustomerEntity customerEntity) {
        return customerDAO.update(customerEntity);
    }

    @Override
    public void deleteById(Integer id) {
        customerDAO.deleteById(id);
    }
    @Override
    public CustomerEntity findById(Integer id){
        return customerDAO.findById(id);
    }
    @Override
    public CustomerEntity findByEmail(String email){
        return customerDAO.findByEmail(email);
    }

}
