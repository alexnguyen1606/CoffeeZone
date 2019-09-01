package com.CoffeeZone.controller.admin;

import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.model.ProductViewModel;
import com.CoffeeZone.service.Impl.BrandService;
import com.CoffeeZone.service.Impl.ProductService;
import com.CoffeeZone.utils.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    private ProductService productService;
   @Autowired
   private ModelMapper modelMapper;
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private BrandService brandService;
    @GetMapping
    public String ProductAdminPage(Model model){
        model.addAttribute("products",productService.findAll());
        return "product-admin";
    }
    @GetMapping("/new")
    public String save(Model model){
        model.addAttribute("viewmodel",new ProductViewModel());
        model.addAttribute("brands",brandService.findAll());
        return "product-form";
    }
    @PostMapping("/new")
    public RedirectView save(Model model, @ModelAttribute("viewmodel") ProductViewModel viewmodel){
        RedirectView rv = new RedirectView();
        ProductEntity productEntity = modelMapper.map(viewmodel,ProductEntity.class);
        BrandEntity brand = brandService.findById(viewmodel.getBrandEntity());
        productEntity.setBrandEntity(brand);
        MultipartFile multipartFile = viewmodel.getMultipartFile();
        if (multipartFile.getContentType().equals("image/jpeg")){
            System.out.println("Type:"+multipartFile.getContentType());
            fileUtils.SaveFile(multipartFile,productEntity);
            productService.save(productEntity);
            rv.setUrl("/admin/product");
            rv.addStaticAttribute("alert","success");
            rv.addStaticAttribute("message","Success");
            return rv;
        }
        else {
            rv.addStaticAttribute("alert","danger");
            rv.addStaticAttribute("message","Wrong TypeFile Import");
            rv.setUrl("/admin/product");
            return rv;
        }

    }
    @GetMapping("/update")
    public String update(Model model,@RequestParam("id") Integer id){
        ProductEntity productEntity = productService.findById(id);
        ProductViewModel viewmodel = new ProductViewModel();
        viewmodel.setId(productEntity.getId());
        viewmodel.setName(productEntity.getName());
        viewmodel.setDescription(productEntity.getDescription());
        viewmodel.setFlavor(productEntity.getFlavor());
        viewmodel.setStatus(productEntity.getStatus());
        viewmodel.setQuantity(productEntity.getQuantity());
        viewmodel.setImage(productEntity.getImage());
        viewmodel.setWeight(productEntity.getWeight());
        viewmodel.setPrice(productEntity.getPrice());
        viewmodel.setBrandEntity(productEntity.getBrandEntity().getId());
        model.addAttribute("brands",brandService.findAll());
        model.addAttribute("viewmodel",viewmodel);
        return "product-form-update";
    }
    @PostMapping("/update")
    public RedirectView update(Model model,@ModelAttribute("viewmodel") ProductViewModel viewmodel){
        RedirectView rv = new RedirectView("/admin/product");
        ProductEntity productEntity = modelMapper.map(viewmodel,ProductEntity.class);
        BrandEntity brand = brandService.findById(viewmodel.getBrandEntity());
        productEntity.setBrandEntity(brand);
        MultipartFile multipartFile = viewmodel.getMultipartFile();
        if (multipartFile!=null){
            if(multipartFile.getContentType().equals("image/jpeg")){
                fileUtils.SaveFile(multipartFile,productEntity);
                productService.update(productEntity);
                rv.addStaticAttribute("alert","success");
                rv.addStaticAttribute("message","Update Success");
                return rv;
            }
            else {
                rv.addStaticAttribute("alert","danger");
                rv.addStaticAttribute("message","Update fail!");
                return rv;
            }
        }
        else {
         //   fileUtils.SaveFile(multipartFile,productEntity);
            productService.update(productEntity);
            rv.addStaticAttribute("alert","success");
            rv.addStaticAttribute("message","Update Success");
            return rv;
        }


    }
    @GetMapping("/{id}")
    public RedirectView Delete(@PathVariable("id") Integer id, Model model){
        productService.deleteById(id);
        model.addAttribute("products",productService.findAll());
        RedirectView rv = new RedirectView();
        rv.setUrl("/admin/product");
        rv.addStaticAttribute("alert","success");
        rv.addStaticAttribute("message","Delete Success");
        return rv;
    }

}
