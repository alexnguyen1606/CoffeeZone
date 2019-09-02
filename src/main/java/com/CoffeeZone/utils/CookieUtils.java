package com.CoffeeZone.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class CookieUtils {
    public void createCookie(HttpServletResponse response,String username,String fullname,String role){
        Cookie cookie1 = new Cookie("USERNAME",username);
        cookie1.setMaxAge(12*60*60);
        response.addCookie(cookie1);
        try {
            Cookie   cookie2 = new Cookie("FULLNAME", URLEncoder.encode(fullname,"UTF-8"));
            cookie2.setMaxAge(12*60*60);
            //cookie2.setPath("/");
            response.addCookie(cookie2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Cookie cookie3 = new Cookie("ROLES",role);
        cookie3.setMaxAge(12*60*60);
        //cookie3.setPath("/");
        response.addCookie(cookie3);
    }
    public void deleteCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies= request.getCookies();
        for(Cookie cookie : cookies){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
    public String getValueCookieByUsername(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String ByWho="";
        for (int i=0;i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("USERNAME")) {
                    ByWho = cookie.getValue();
            }
        }
        return ByWho;
    }
}
