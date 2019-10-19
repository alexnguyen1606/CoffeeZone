package com.CoffeeZone.controller;

import com.CoffeeZone.dao.Impl.ProductDAO;
import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.model.Cart;
import com.CoffeeZone.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CartUtils cartUtils;

    @GetMapping
    public String cart(Model model,HttpSession session){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        if (cartItems==null){
            cartItems = new HashMap<>();
        }
        cartUtils.SessionCart(session,cartItems);
        return "cart-items";
    }

    @GetMapping("/add")
    public RedirectView add(@RequestParam("id") Integer id, HttpSession session, Model model){
        HashMap<Integer,Cart> cartItems =(HashMap<Integer,Cart>)session.getAttribute("cartItems");

       cartUtils.addItem(session,cartItems,id);

        model.addAttribute("products",(ArrayList<ProductEntity>)productDAO.findByStatus());
        return new RedirectView("/");
    }

    @GetMapping("/sub/{id}")
    public String subItem(@PathVariable("id") Integer id,HttpSession session){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        cartUtils.subItem(session,cartItems,id);
        return "cart-items";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id,HttpSession session,Model model){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        cartUtils.removeItem(session,cartItems,id);
        return "cart-items";
    }
}
