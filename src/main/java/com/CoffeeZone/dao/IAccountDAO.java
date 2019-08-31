package com.CoffeeZone.dao;

import com.CoffeeZone.entity.AccountEntity;

public interface IAccountDAO extends GenericDAO<AccountEntity> {
    AccountEntity findByUsernameAndPasswordAndStatus(String username,String password);
    AccountEntity findByUsername(String username);
}
