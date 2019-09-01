package com.CoffeeZone.importfile;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.service.Impl.BrandService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
@Component
public class ProductExcelImport {
    @Autowired
    private BrandService brandService;
    public ArrayList<ProductEntity> ReadFileExcel(File file){
        try  {
            ArrayList<ProductEntity> products = new ArrayList<>();
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();

            Iterator<Row> iterator = sheet.iterator();
            Row fistRow =   iterator.next();
            Cell fistCell = fistRow.getCell(0);
            System.out.println(fistCell.getStringCellValue());
            while (iterator.hasNext()){
                Row row = iterator.next();
                ProductEntity product = new ProductEntity();
                product.setName(row.getCell(0).getStringCellValue());
                product.setDescription(row.getCell(1).getStringCellValue());
                product.setFlavor(row.getCell(2).getStringCellValue());
                product.setQuantity(Integer.parseInt(fmt.formatCellValue(row.getCell(3))));
                product.setWeight(row.getCell(4).getStringCellValue());
                product.setPrice(Integer.parseInt(fmt.formatCellValue(row.getCell(5))));
                int brandId = Integer.parseInt(fmt.formatCellValue(row.getCell(6)));
                product.setBrandEntity(brandService.findById(brandId));
                product.setStatus(Integer.parseInt(fmt.formatCellValue(row.getCell(7))));
                products.add(product);
            }
            return products;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
