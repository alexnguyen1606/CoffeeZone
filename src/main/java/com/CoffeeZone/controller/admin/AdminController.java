package com.CoffeeZone.controller.admin;

import com.CoffeeZone.entity.AccountEntity;
import com.CoffeeZone.service.Impl.ProductService;
import com.CoffeeZone.utils.StatisticalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StatisticalUtils statisticalUtils;
    @GetMapping("/admin")
    public String index(Model model, HttpSession session)
    {
        String accountEntity = (String) session.getAttribute("USERNAME");
        return "home-admin";
    }
    @GetMapping("/admin/chart")
    public String chart(Model model) {
        model.addAttribute("map",statisticalUtils.ProductSaleStaticstical());
        return "chart";
    }


}
