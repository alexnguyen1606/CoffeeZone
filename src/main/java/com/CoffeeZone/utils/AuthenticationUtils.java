package com.CoffeeZone.utils;

import com.CoffeeZone.entity.AccountEntity;
import com.CoffeeZone.service.Impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUtils {
    @Autowired
    private AccountService accountService;

    public AccountEntity isAuthentication(String username,String password){
        AccountEntity account = accountService.findByUsernameAndPasswordAndStatus(username,password);
        return account;
    }
    public Boolean isExits(String username){
        AccountEntity account=accountService.findByUsername(username);
        if (account==null){
            return true;
        }
        else
            return false;
    }

}
