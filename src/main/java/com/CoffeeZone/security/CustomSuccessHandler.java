package com.CoffeeZone.security;

import com.CoffeeZone.utils.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException{

        String targetUrl =determineTargetUrl(authentication);
        if (response.isCommitted()){
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }

    private String determineTargetUrl(Authentication authentication) {
        String url="";
        List<String> roles = SecurityUtils.getAuthorities();
        if(isAdmin(roles)){
            url="/admin";
        }
        else if(isUser(roles)){
            url="/";
        }
        return url;
    }
    private Boolean isAdmin(List<String> roles){
        if (roles.contains("ADMIN")){
            return true;
        }
        else
            return false;
    }
    private Boolean isUser(List<String> roles){
        if (roles.contains("USER")){
            return true;
        }
        else
            return false;
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
