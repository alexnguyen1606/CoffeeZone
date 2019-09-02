package com.CoffeeZone.controller.admin;

import com.CoffeeZone.entity.OrderDetailEntity;
import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.sendmail.SendMail;
import com.CoffeeZone.service.Impl.OrderDetailService;
import com.CoffeeZone.service.Impl.OrderService;
import com.CoffeeZone.service.Impl.ProductService;
import com.CoffeeZone.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/orderprocessing")
public class OrderProcessingController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CookieUtils cookieUtils;
    @Autowired
    private SendMail sendMail;
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
    @GetMapping("/cancel/{id}")
    public RedirectView cancel(@PathVariable("id") Integer id){
        OrderEntity order = orderService.findById(id);
        RedirectView rv = new RedirectView("/admin/orderprocessing");
        try {
            orderService.deleteById(id);
            sendMail.cancelOrder(order);
            rv.addStaticAttribute("message","Success");
            rv.addStaticAttribute("alert","success");
        }catch (Exception e){
            rv.addStaticAttribute("message","Fail Process");
            rv.addStaticAttribute("alert","danger");
            return rv;
        }
        return rv;
    }
    @GetMapping("/confirm/{id}")
    public RedirectView confirmOrder(@PathVariable("id") Integer id, Model model, HttpServletRequest request){
        OrderEntity orderEntity = orderService.findById(id);
        orderEntity.setStatus(true);
        String modifiedBy = cookieUtils.getValueCookieByUsername(request);
        orderEntity.setModifiedBy(modifiedBy);
        orderService.update(orderEntity);
        for(OrderDetailEntity od : orderDetailService.findByOrderId(id)){
            ProductEntity productEntity = productService.findById(od.getProduct().getId());
            productEntity.setQuantity(productEntity.getQuantity()-od.getQuantity());
            productEntity.setModifiedBy(modifiedBy);
            od.setStatus(true);
            od.setModifiedBy(modifiedBy);
            orderDetailService.update(od);
            productService.update(productEntity);
        }
        sendMail.acceptOrder(orderEntity);
        RedirectView rv = new RedirectView("/admin/orderprocessing");
        rv.addStaticAttribute("message","Confirm Success!");
        rv.addStaticAttribute("alert","success");
        return rv;
    }
}
