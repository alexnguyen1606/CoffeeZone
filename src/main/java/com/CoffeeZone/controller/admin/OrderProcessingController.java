package com.CoffeeZone.controller.admin;

import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.service.Impl.OrderDetailService;
import com.CoffeeZone.service.Impl.OrderService;
import com.CoffeeZone.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/orderprocessing")
public class OrderProcessingController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;
    @GetMapping
    public String Index(Model model){
        model.addAttribute("orderProcess",orderService.findAll());
        return "order-processing";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id,Model model){
        model.addAttribute("orderDetails",orderDetailService.findByOrderId(id));
        model.addAttribute("order",orderService.findById(id));
        return "order-process-detail";
    }
    @GetMapping("/confirm/{id}")
    public RedirectView confirmOrder(@PathVariable("id") Integer id, Model model){
        OrderEntity orderEntity = orderService.findById(id);
        orderEntity.setStatus(true);
        orderService.update(orderEntity);
        for(OrderDetailEntity od : orderDetailService.findByOrderId(id)){
            ProductEntity productEntity = productService.findById(od.getProduct().getId());
            productEntity.setQuantity(productEntity.getQuantity()-od.getQuantity());
            od.setStatus(true);
            orderDetailService.update(od);
            productService.update(productEntity);
        }
        return new RedirectView("/admin/orderprocessing");
    }
}
