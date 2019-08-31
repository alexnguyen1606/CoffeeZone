package com.CoffeeZone.exportfile;

import com.CoffeeZone.entity.BrandEntity;
import com.CoffeeZone.service.Impl.BrandService;
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
public class BrandExcel {
    @Autowired
    private BrandService brandService;
    public void ExportListBrand(){
        File file = new File(FileConstants.PATH_EXCEL+ ExcelConstants.ListBrand);
        if (file.exists()){
            System.out.println("File is exits");
            exits(file);
        }
        else{
            System.out.println("File Not found");
            unexits(file);
        }

    }
    public void exits(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int numRow =0;
            Row firstRow = sheet.createRow(numRow++);
            setCell(firstRow);
            ArrayList<BrandEntity> brands = brandService.findAll();
            for(BrandEntity brand: brands){
                Row row = sheet.createRow(numRow++);
                setCellData(row,brand);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unexits(File file) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet =workbook.createSheet("List Brand");
        int numRow =0;
        Row firstRow = sheet.createRow(numRow++);
        setCell(firstRow);
        ArrayList<BrandEntity> brands = brandService.findAll();
        for(BrandEntity brand: brands){
            Row row = sheet.createRow(numRow++);
            setCellData(row,brand);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCell(Row row){
        Cell cell1 = row.createCell(0);
        cell1.setCellValue("Brand Code");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("Brand Name");
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("Description");
        Cell cell4 = row.createCell(3);
        cell4.setCellValue("Established");
        Cell cell5 = row.createCell(4);
        cell5.setCellValue("Status");
    }
    public void setCellData(Row row, BrandEntity brand){
        Cell cell1 = row.createCell(0);
        cell1.setCellValue(brand.getId());
        Cell cell2 = row.createCell(1);
        cell2.setCellValue(brand.getName());
        Cell cell3 = row.createCell(2);
        cell3.setCellValue(brand.getDescription());
        Cell cell4 = row.createCell(3);
        cell4.setCellValue(brand.getEstablieshed());
        Cell cell5 = row.createCell(4);
        cell5.setCellValue(brand.getStatus()? 1:0);
    }
}
