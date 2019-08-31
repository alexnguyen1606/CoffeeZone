package com.CoffeeZone.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

@Component
public class SessionUtils {
    public void createSession(HttpSession session,String username,String fullname,String role){
        session.setAttribute("USERNAME",username);
        session.setAttribute("FULLNAME",fullname);
        session.setAttribute("ROLES",role);
    }
    public void deleteSession(HttpSession session){
        if (!session.getAttribute("USERNAME").equals("")){
            session.removeAttribute("USERNAME");
            session.removeAttribute("ROLES");
            session.removeAttribute("FULLNAME");
        }
    }

}
