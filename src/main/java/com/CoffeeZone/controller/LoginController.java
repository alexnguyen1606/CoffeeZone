package com.CoffeeZone.controller;

import com.CoffeeZone.entity.AccountEntity;
import com.CoffeeZone.model.LoginViewModel;
import com.CoffeeZone.service.Impl.AccountService;
import com.CoffeeZone.utils.AuthenticationUtils;
import com.CoffeeZone.utils.CookieUtils;
import com.CoffeeZone.utils.SessionUtils;
import com.CoffeeZone.utils.VerifyUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private SessionUtils sessionUtils;
    @Autowired
    private AuthenticationUtils authenticationUtils;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CookieUtils cookieUtils;
    @GetMapping(value = {"/login","/admin/login"})
    public String LoginPage(Model model){
        model.addAttribute("viewmodel",new LoginViewModel());
        return "login";
    }
    @PostMapping("/login")
    public RedirectView login(@ModelAttribute("viewmodel") LoginViewModel viewmodel,
                              @RequestParam("g-recaptcha-response") String gRecapcha, HttpServletResponse response){
       String username = viewmodel.getUsername();
       String password = viewmodel.getPassword();
       RedirectView rv = new RedirectView();
       Boolean valid = true;
       AccountEntity account = authenticationUtils.isAuthentication(username,password);
       if (account==null){
            valid = false;
            rv.addStaticAttribute("message","Username or Password not valid");
            rv.setUrl("/login");
            return rv;
       }
       if (valid){
           String gReCaptchaResponese = gRecapcha;
           valid = VerifyUtils.verify(gReCaptchaResponese);
           if(!valid){
               rv.addStaticAttribute("message","Captcha Invalid");
               rv.setUrl("/login");
               return rv;
           }
       }
       if(valid){
           cookieUtils.createCookie(response,account.getUsername(),account.getName(),account.getRoleEntities().toString());
            rv.setUrl("/admin");
            return rv;
       }
       return new RedirectView("/login");
    }
    @GetMapping("/logout")
    public RedirectView home( HttpServletRequest request,HttpServletResponse response){
        cookieUtils.deleteCookie(request,response);
        return new RedirectView("/");
    }
    @PostMapping("/register")
    public RedirectView register(@ModelAttribute("viewmodel") LoginViewModel viewmodel,Model model,HttpServletResponse response){
        RedirectView rv = new RedirectView();
        if(authenticationUtils.isExits(viewmodel.getUsername())){
            AccountEntity account = modelMapper.map(viewmodel,AccountEntity.class);
            account=accountService.save(account);
            cookieUtils.createCookie(response,account.getUsername(),account.getName(),account.getRoleEntities().toString());
            rv.setUrl("/");
            return rv;
        }
        else {
            rv.addStaticAttribute("message","Tài khoản đã tồn tại");
            rv.setUrl("/login");
            model.addAttribute("viewmodel",viewmodel);
            return rv;
        }
    }
}
