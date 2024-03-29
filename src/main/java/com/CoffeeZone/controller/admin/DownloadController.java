package com.CoffeeZone.controller.admin;

import com.CoffeeZone.exportfile.BrandExcel;
import com.CoffeeZone.exportfile.ProductExcel;
import com.CoffeeZone.systemconstants.ExcelConstants;
import com.CoffeeZone.systemconstants.FileConstants;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping(value = "/admin/download")
public class DownloadController {
    @Autowired
    private ServletContext context;
    @Autowired
    private ProductExcel productExcel;
    @Autowired
    private BrandExcel brandExcel;

    @GetMapping("/listProduct")
    public void downloadListProuduct(HttpServletResponse response){
        productExcel.ExportListProduct();
        File file = new File(FileConstants.PATH_EXCEL+ExcelConstants.ListProduct);
        dowload(file,response);
    }

    @GetMapping("/listBrand")
    public void downloadListBrand(HttpServletResponse response){
        brandExcel.ExportListBrand();
        File file = new File(FileConstants.PATH_EXCEL+ ExcelConstants.ListBrand);
       dowload(file,response);
    }

    @GetMapping("/listOrder")
    public void downloadListOrder(HttpServletResponse response){
        File file = new File(FileConstants.PATH_EXCEL+"Danh_Sach_Don_Hang.xlsx");
       dowload(file,response);
    }

    public void dowload(File file,HttpServletResponse response){
        InputStream inputStream=null;
        try {
            byte[] data = FileUtils.readFileToByteArray(file);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition","attachment;filename="+file.getName());
            response.setContentLength(data.length);
            inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
            FileCopyUtils.copy(inputStream,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
