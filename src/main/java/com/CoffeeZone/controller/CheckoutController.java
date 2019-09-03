package com.CoffeeZone.controller;

import com.CoffeeZone.entity.CustomerEntity;
import com.CoffeeZone.model.Cart;
import com.CoffeeZone.service.Impl.*;
import com.CoffeeZone.utils.CheckoutUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CheckoutUtils checkoutUtils;

    @GetMapping("/formInfo")
    public String formInfoPage(Model model){
        model.addAttribute("customer",new CustomerEntity());
        return "form-checkout";
    }

    @PostMapping
    public RedirectView checkout(@ModelAttribute("customer") CustomerEntity customer, HttpSession session, Model model){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        int totalPrice = (int) session.getAttribute("totalPrice");
        CustomerEntity customerCheck = customerService.findByEmail(customer.getEmail());
        if (customerCheck!=null){
            checkoutUtils.checkout(cartItems,customerCheck,totalPrice);
        }
       else {
            checkoutUtils.checkout(cartItems, customer, totalPrice);
        }
        session.setAttribute("cartItems",cartItems);
        session.setAttribute("totalItem",0);
        model.addAttribute("products",productService.findByStatus());
        return new RedirectView("/");
    }
}
