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
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Success");
        return rv;
    }

    @GetMapping("/update/{id}")
    public String updateBrand(@PathVariable("id") Integer id,Model model) {
        BrandViewModel viewmodel = modelMapper.map(brandService.findById(id),BrandViewModel.class);
        model.addAttribute("viewmodel",viewmodel);
        return "brand-form-update";
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("viewmodel") BrandViewModel viewmodel){
        BrandEntity brand = modelMapper.map(viewmodel,BrandEntity.class);
        brandService.update(brand);
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Update Success");
        return rv;
    }

    @GetMapping("/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        brandService.deleteById(id);
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Delete Success");
        return rv;
    }

}
