package com.CoffeeZone.utils;

import com.CoffeeZone.dao.Impl.AccountDAO;
import com.CoffeeZone.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtils {
    @Autowired
    private AccountDAO accountDAO;

    public AccountEntity isAuthentication(String username,String password){
        AccountEntity account = accountDAO.findByUsernameAndPasswordAndStatus(username,password);
        return account;
    }
    public Boolean isExits(String username){
        AccountEntity account=accountDAO.findByUsername(username);
        if (account==null){
            return true;
        }
        else
            return false;
    }

}
