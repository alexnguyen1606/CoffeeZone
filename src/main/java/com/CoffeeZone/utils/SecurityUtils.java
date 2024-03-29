package com.CoffeeZone.utils;

import com.CoffeeZone.dto.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtils {
    public static List<String> getAuthorities(){
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for(GrantedAuthority authority : authorities){
            results.add(authority.getAuthority());
        }
        return results;
    }
    public static MyUser getPrinciple(){
        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUser;
    }
}
