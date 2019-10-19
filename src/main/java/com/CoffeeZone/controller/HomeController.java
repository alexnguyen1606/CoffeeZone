package com.CoffeeZone.controller;

import com.CoffeeZone.dao.Impl.ProductDAO;
import com.CoffeeZone.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDAO;

	@GetMapping(value="/")
	public String Home(Model model, HttpSession session) {
		ArrayList<ProductEntity> products=productDAO.findByStatus();
		model.addAttribute("products",products);
		return "home";
	}
}
