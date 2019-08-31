package com.CoffeeZone.controller;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.model.Cart;
import com.CoffeeZone.service.Impl.ProductService;
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
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public String cart(Model model,HttpSession session){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        if (cartItems==null){
            cartItems = new HashMap<>();
        }
        session.setAttribute("cartItems",cartItems);
        session.setAttribute("totalPrice",totalPrice(cartItems));
        session.setAttribute("numberOfItem",cartItems.size());
        session.setAttribute("totalItem",totalItem(cartItems));
        return "cart-items";
    }
    @GetMapping("/add")
    public RedirectView add(@RequestParam("id") Integer id, HttpSession session, Model model){
        HashMap<Integer,Cart> cartItems =(HashMap<Integer,Cart>)session.getAttribute("cartItems");

        if (cartItems==null){
            cartItems = new HashMap<>();
        }
        ProductEntity product = productService.findById(id);
        if(product!=null){
            if(product.getQuantity()>0&&product.getQuantity()!=0) {
                if (cartItems.containsKey(product.getId())) {
                    Cart item = cartItems.get(id);
                    item.setProduct(product);
                    item.setQuantity(item.getQuantity() + 1);
                    cartItems.put(id, item);
                } else {
                    Cart item = new Cart();
                    item.setProduct(product);
                    item.setQuantity(1);
                    cartItems.put(id, item);
                }
            }
        }

        session.setAttribute("cartItems",cartItems);
        session.setAttribute("totalPrice",totalPrice(cartItems));
        session.setAttribute("numberOfItem",cartItems.size());
        session.setAttribute("totalItem",totalItem(cartItems));
        model.addAttribute("products",(ArrayList<ProductEntity>)productService.findByStatus());
        return new RedirectView("/");
    }
    @GetMapping("/sub/{id}")
    public String subItem(@PathVariable("id") Integer id,HttpSession session){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        if (cartItems==null){
            cartItems = new HashMap<>();
        }
        if (cartItems.containsKey(id)){
            Cart item = cartItems.get(id);
            if(item.getQuantity()>0){
                item.setQuantity(item.getQuantity()-1);
            }
            if(item.getQuantity()==0){
                cartItems.remove(id);
            }
            else {
                cartItems.put(id,item);
            }
        }

        session.setAttribute("cartItem",cartItems);
        session.setAttribute("totalPrice",totalPrice(cartItems));
        session.setAttribute("numberOfItem",cartItems.size());
        session.setAttribute("totalItem",totalItem(cartItems));
        return "cart-items";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id,HttpSession session,Model model){
        HashMap<Integer,Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("cartItems");
        if(cartItems==null){
            cartItems= new HashMap<>();
        }
        if (cartItems.containsKey(id)){
            cartItems.remove(id);
        }
        session.setAttribute("cartItems",cartItems);
        session.setAttribute("totalPrice",totalPrice(cartItems));
        session.setAttribute("numberOfItem",cartItems.size());
        session.setAttribute("totalItem",totalItem(cartItems));
        return "cart-items";
    }
    public Integer totalPrice(HashMap<Integer,Cart> cartItems){
        int count =0;
        for (Map.Entry<Integer,Cart> list:cartItems.entrySet()){
            count+= list.getValue().getProduct().getPrice()*list.getValue().getQuantity();
        }
        return count;
    }
    public int totalItem(HashMap<Integer,Cart> cartItems){
        int count =0;
        for (Map.Entry<Integer,Cart> list : cartItems.entrySet()){
            count += list.getValue().getQuantity();
        }
        return count;
    }
}
