package com.CoffeeZone.controller.admin;

import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.model.BrandViewModel;
import com.CoffeeZone.service.Impl.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("brands",brandService.findAll());
        return "brand-admin";
    }
    @GetMapping("/new")
    public String newBrand(Model model){
        model.addAttribute("viewmodel",new BrandViewModel());
        return "brand-form";
    }
    @PostMapping("/new")
    public RedirectView save(@ModelAttribute("viewmodel") BrandViewModel viewmodel){
        BrandEntity brand = modelMapper.map(viewmodel,BrandEntity.class);
        brandService.save(brand);
        return new RedirectView("/admin/brand");
    }
}
