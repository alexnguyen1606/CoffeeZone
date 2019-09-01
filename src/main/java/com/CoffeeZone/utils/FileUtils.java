package com.CoffeeZone.utils;

import com.CoffeeZone.entity.ProductEntity;
import com.CoffeeZone.systemconstants.FileConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtils {
    public void SaveFile(MultipartFile multipartFile, ProductEntity productEntity){
        String originalName = multipartFile.getOriginalFilename();
        File file = new File(FileConstants.PATH+originalName);
        try {
            if(!originalName.equals("")){
                multipartFile.transferTo(file);
                productEntity.setImage(FileConstants.FILE_PATH+originalName);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    public File importFile(MultipartFile multipartFile){
        File file = new File(FileConstants.PATH_EXCEL+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
