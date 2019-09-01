package com.CoffeeZone.importfile;

import com.CoffeeZone.entity.BrandEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Component
public class BrandExcelImport {

    public ArrayList<BrandEntity> ReadFileExcel(File file){
        FileInputStream fileInputStream = null;
        try  {
            fileInputStream = new FileInputStream(file);
            ArrayList<BrandEntity> brands = new ArrayList<>();
            DataFormatter fmt = new DataFormatter();
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            Row fistRow  = iterator.next();
            Cell fistCell = fistRow.getCell(0);
            while (iterator.hasNext()){
                Row row = iterator.next();
                BrandEntity brand = new BrandEntity();
                brand.setName(row.getCell(0).getStringCellValue());
                brand.setDescription(row.getCell(1).getStringCellValue());
                brand.setEstablieshed(Integer.parseInt(fmt.formatCellValue(row.getCell(2))));
                int status = Integer.parseInt(fmt.formatCellValue(row.getCell(3)));
                brand.setStatus(status==1?true:false);
                brands.add(brand);
            }
            return brands;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream!=null)
                    fileInputStream.close();
            }catch (IOException io){
                io.printStackTrace();
            }

        }
        return null;
    }
}
