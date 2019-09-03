package com.CoffeeZone.utils;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.model.Cart;
import com.CoffeeZone.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
@Component
public class CartUtils {

    @Autowired
    private ProductService productService;

    public void addItem(HttpSession session,HashMap<Integer,Cart> cartItems,Integer id){
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
        SessionCart(session,cartItems);
    }
    public void subItem(HttpSession session,HashMap<Integer,Cart> cartItems,Integer id){
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
        SessionCart(session,cartItems);
    }
    public void removeItem(HttpSession session,HashMap<Integer,Cart> cartItems,Integer id){
        if(cartItems==null){
            cartItems= new HashMap<>();
        }
        if (cartItems.containsKey(id)){
            cartItems.remove(id);
        }
        SessionCart(session,cartItems);
    }
    public void SessionCart(HttpSession session,HashMap<Integer,Cart> cartItems){
        session.setAttribute("cartItems",cartItems);
        session.setAttribute("totalPrice",totalPrice(cartItems));
        session.setAttribute("numberOfItem",cartItems.size());
        session.setAttribute("totalItem",totalItem(cartItems));
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
