package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dao.Impl.AccountDAO;
import com.CoffeeZone.entity.AccountEntity;
import com.CoffeeZone.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountDAO accountDAO;
    @Override
    public AccountEntity findByUsernameAndPasswordAndStatus(String username,String password) {
        return accountDAO.findByUsernameAndPasswordAndStatus(username,password);
    }

    @Override
    public AccountEntity findByUsername(String username) {

        return accountDAO.findByUsername(username);
    }

    @Override
    public ArrayList<AccountEntity> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public AccountEntity save(AccountEntity accountEntity) {
        return accountDAO.save(accountEntity);
    }

    @Override
    public AccountEntity update(AccountEntity accountEntity) {
        return accountDAO.update(accountEntity);
    }

    @Override
    public void deleteById(Integer id) {
        accountDAO.deleteById(id);
    }

    @Override
    public AccountEntity findById(Integer id) {
        return null;
    }
}
