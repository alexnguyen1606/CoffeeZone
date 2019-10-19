package com.CoffeeZone.controller.admin;

import com.CoffeeZone.dao.Impl.BrandDAO;
import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.model.BrandViewModel;
import com.CoffeeZone.utils.CookieUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/brand")
public class BrandController {
    @Autowired
    private BrandDAO brandDAO;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CookieUtils cookieUtils;

    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("brands",brandDAO.findAll());
        return "brand-admin";
    }
    @GetMapping("/new")
    public String newBrand(Model model){
        model.addAttribute("viewmodel",new BrandViewModel());
        return "brand-form";
    }
    @PostMapping("/new")
    public RedirectView save(@ModelAttribute("viewmodel") BrandViewModel viewmodel, HttpServletRequest request){
        BrandEntity brand = modelMapper.map(viewmodel,BrandEntity.class);
        String createdBy = cookieUtils.getValueCookieByUsername(request);
        brand.setCreatedBy(createdBy);
        brandDAO.save(brand);
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Success");
        return rv;
    }

    @GetMapping("/update/{id}")
    public String updateBrand(@PathVariable("id") Integer id,Model model) {
        BrandViewModel viewmodel = modelMapper.map(brandDAO.findById(id),BrandViewModel.class);
        model.addAttribute("viewmodel",viewmodel);
        return "brand-form-update";
    }

    @PostMapping("/update")
    public RedirectView update(@ModelAttribute("viewmodel") BrandViewModel viewmodel,HttpServletRequest request){
        BrandEntity brand = modelMapper.map(viewmodel,BrandEntity.class);
        String modifiedBy = cookieUtils.getValueCookieByUsername(request);
        brand.setModifiedBy(modifiedBy);
        brandDAO.update(brand);
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Update Success");
        return rv;
    }

    @GetMapping("/{id}")
    public RedirectView delete(@PathVariable("id") Integer id){
        brandDAO.deleteById(id);
        RedirectView rv = new RedirectView("/admin/brand");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Delete Success");
        return rv;
    }

}
