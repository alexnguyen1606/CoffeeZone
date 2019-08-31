package com.CoffeeZone.controller;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping(value="/")
	public String Home(Model model, HttpSession session) {
		ArrayList<ProductEntity> products=productService.findByStatus();
		model.addAttribute("products",products);
		return "home";
	}
}
