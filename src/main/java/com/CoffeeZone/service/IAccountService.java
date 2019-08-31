package com.CoffeeZone.service;

import com.CoffeeZone.entity.AccountEntity;

public interface IAccountService extends GenericService<AccountEntity> {
    AccountEntity findByUsernameAndPasswordAndStatus(String username,String password);
    AccountEntity findByUsername(String username);
}
