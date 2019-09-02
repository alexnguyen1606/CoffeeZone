package com.CoffeeZone.utils;

import com.CoffeeZone.entity.CustomerEntity;
import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.model.Cart;
import com.CoffeeZone.sendmail.SendMail;
import com.CoffeeZone.service.Impl.CustomerService;
import com.CoffeeZone.service.Impl.OrderDetailService;
import com.CoffeeZone.service.Impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CheckoutUtils {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private SendMail sendMail;

    public void checkout(HashMap<Integer,Cart> cartItems, CustomerEntity customer, int totalPrice){
        OrderEntity order = new OrderEntity();
        order.setStatus(false);
        order.setTotalMoney(totalPrice);
        CustomerEntity customerInDb;
        if (customer.getId()==null){
            customerInDb = customerService.save(customer);
        }
        else {
             customerInDb = customer;
        }
        try {
            order.setCustomer(customerInDb);
            order = orderService.save(order);
            for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
                OrderDetailEntity orderDetail = new OrderDetailEntity();
                orderDetail.setQuantity(list.getValue().getQuantity());
                orderDetail.setOrder(order);
                orderDetail.setProduct(list.getValue().getProduct());
                orderDetail = orderDetailService.save(orderDetail);
            }
            sendMail.ConfirmOrder(customerInDb.getEmail(),totalPrice,order,cartItems);
            cartItems.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
