package com.CoffeeZone.utils;

import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.service.Impl.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class StatisticalUtils {

    @Autowired
    private OrderDetailService orderDetailService;
    public HashMap<String,Integer> ProductSaleStaticstical(){
        ArrayList<OrderDetailEntity> list = orderDetailService.findByStatus();
        HashMap<String,Integer> map = new HashMap<>();
        for (OrderDetailEntity od : list){
            String name = od.getProduct().getName();
            Integer total = od.getQuantity()*od.getProduct().getPrice();
            if(map.containsKey(name)){
                map.put(name,map.get(name)+total);
            }
            else {
                map.put(name,total);
            }
        }
        return map;
    }
}
