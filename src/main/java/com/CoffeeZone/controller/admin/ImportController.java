package com.CoffeeZone.controller.admin;

import com.CoffeeZone.importfile.BrandExcelImport;
import com.CoffeeZone.importfile.ProductExcelImport;
import com.CoffeeZone.service.Impl.BrandService;
import com.CoffeeZone.service.Impl.ProductService;
import com.CoffeeZone.utils.CookieUtils;
import com.CoffeeZone.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("/admin/import")
public class ImportController {
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductExcelImport productExcelImport;
    @Autowired
    private BrandExcelImport brandExcelImport;
    @Autowired
    private CookieUtils cookieUtils;

    String xlsx = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    @PostMapping("/product")
    public RedirectView importProduct(@RequestParam("multifile")MultipartFile multipartFile, HttpServletRequest request){
        System.out.println("type:"+multipartFile.getContentType());
        RedirectView rv = new RedirectView();
        String createdBy = cookieUtils.getValueCookieByUsername(request);
        if (multipartFile.getContentType().equals(xlsx)||multipartFile==null){
            File file=fileUtils.importFile(multipartFile);
            rv.setUrl("/admin/product");
            try {
                productService.saveAll(productExcelImport.ReadFileExcel(file),createdBy);
                rv.addStaticAttribute("alert","success");
                rv.addStaticAttribute("message","Import Success");
            }
            catch (Exception e){
                e.printStackTrace();
                rv.addStaticAttribute("alert","danger");
                rv.addStaticAttribute("message","Sai định dạnh cột");
                file.delete();
                return rv;
            }
            return rv;
        }
        else {
            rv.addStaticAttribute("alert","danger");
            rv.addStaticAttribute("message","Wrong TypeFile Import or Null");
            rv.setUrl("/admin/product/new");
            return rv;
        }
    }
    @PostMapping("/brand")
    public RedirectView importBrand(@RequestParam("multifile")MultipartFile multipartFile,HttpServletRequest request){
        RedirectView rv = new RedirectView();
        String createdBy = cookieUtils.getValueCookieByUsername(request);
        if (multipartFile.getContentType().equals(xlsx)||multipartFile==null){
            File file =fileUtils.importFile(multipartFile);
            rv.setUrl("/admin/brand");
            try {
                brandService.saveAll(brandExcelImport.ReadFileExcel(file),createdBy);
                rv.addStaticAttribute("alert","success");
                rv.addStaticAttribute("message","Import Success");
            }catch (Exception e){
                e.printStackTrace();
                file.delete();
                rv.addStaticAttribute("alert","danger");
                rv.addStaticAttribute("message","Sai định dạnh cột");
                return rv;
            }
            return rv;
        }else {
            rv.addStaticAttribute("alert","danger");
            rv.addStaticAttribute("message","Wrong TypeFile Import or Null");
            rv.setUrl("/admin/brand/new");
            return rv;
        }

    }
}
