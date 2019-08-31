package com.CoffeeZone.exportfile;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.service.Impl.ProductService;
import com.CoffeeZone.systemconstants.ExcelConstants;
import com.CoffeeZone.systemconstants.FileConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;

@Component
public class ProductExcel {
    @Autowired
    private ProductService productService;

    public void ExportListProduct(){
        File file = new File(FileConstants.PATH_EXCEL+ ExcelConstants.ListProduct);
        if (file.exists()){
            exits(file);
        }
        else {
                unexits(file);

        }
    }
    public void exits(File file){
        System.out.println("File exists");
        try  {
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRow = 0;
            Row firstRow = sheet.createRow(numRow++);
            setCell(firstRow);
            ArrayList<ProductEntity> products = productService.findAll();
            for(ProductEntity product : products){
                Row row = sheet.createRow(numRow++);
                setCellData(row,product);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            fileInputStream.close();
            System.out.println("Export Success: "+ file.getName());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void unexits(File file){
        System.out.println("File not found");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Products");
        int numRow = 0;
        Row firstRow = sheet.createRow(numRow++);
        setCell(firstRow);
        ArrayList<ProductEntity> products = productService.findAll();
        for(ProductEntity product : products){
            Row row = sheet.createRow(numRow++);
            setCellData(row,product);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            System.out.println("Export success"+file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setCell(Row firstRow){
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Id");
        Cell Cell1 = firstRow.createCell(1);
        Cell1.setCellValue("Name");
        Cell Cell2 = firstRow.createCell(2);
        Cell2.setCellValue("Description");
        Cell Cell3 = firstRow.createCell(3);
        Cell3.setCellValue("Flavor");
        Cell Cell4 = firstRow.createCell(4);
        Cell4.setCellValue("Quantity");
        Cell Cell5 = firstRow.createCell(5);
        Cell5.setCellValue("Weight");
        Cell Cell6 = firstRow.createCell(6);
        Cell6.setCellValue("Price");
        Cell Cell7 = firstRow.createCell(7);
        Cell7.setCellValue("Brand");
        Cell Cell8 = firstRow.createCell(8);
        Cell8.setCellValue("Status");
    }
    public void setCellData(Row row,ProductEntity product){
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(product.getId());
        Cell cell1 = row.createCell(1);
        cell1.setCellValue(product.getName());
        Cell cell2 = row.createCell(2);
        cell2.setCellValue(product.getDescription());
        Cell cell3 = row.createCell(3);
        cell3.setCellValue(product.getFlavor());
        Cell cell4 = row.createCell(4);
        cell4.setCellValue(product.getQuantity());
        Cell cell5 = row.createCell(5);
        cell5.setCellValue(product.getWeight());
        Cell cell6 = row.createCell(6);
        cell6.setCellValue(product.getPrice());
        Cell cell7 = row.createCell(7);
        cell7.setCellValue(product.getBrandEntity().getName());
        Cell cell8 = row.createCell(8);
        cell8.setCellValue(product.getStatus());
    }
}
