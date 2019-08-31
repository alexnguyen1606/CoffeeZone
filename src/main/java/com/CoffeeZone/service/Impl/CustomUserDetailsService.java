package com.CoffeeZone.service.Impl;

import com.CoffeeZone.dto.MyUser;
import com.CoffeeZone.entity.AccountEntity;
import com.CoffeeZone.entity.RoleEntity;
import com.CoffeeZone.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity accountEntity = accountRepository.findOneByUsernameAndStatus(username,true);
        if (accountEntity==null){
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity roleEntity: accountEntity.getRoleEntities()){
            authorities.add(new SimpleGrantedAuthority(roleEntity.getCode()));
        }
        MyUser myUser = new MyUser(accountEntity.getUsername(),
                accountEntity.getPassword(),true,true,true ,
                true,authorities);
        myUser.setName(accountEntity.getName());
        return myUser;
    }
}
