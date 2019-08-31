package com.CoffeeZone.utils;

import com.CoffeeZone.systemconstants.VerifyConstants;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class VerifyUtils {
    public static final String SITE_VERIFY_URL =
            "https://www.google.com/recaptcha/api/siteverify";
    public static Boolean verify(String gRecapchaResponse){
        if (gRecapchaResponse==null||gRecapchaResponse.length()==0){
            return false;
        }
        try {
            URL verifyURL = new URL(SITE_VERIFY_URL);
            HttpURLConnection connection = (HttpURLConnection) verifyURL.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent","Mozilla/5.0");
            connection.setRequestProperty("Accept-language","en-US,en;q=0.5");
            String postParam = "secret="+ VerifyConstants.SECRET_KEY+"&response="+gRecapchaResponse;
            connection.setDoOutput(true);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(postParam.getBytes());
            outputStream.flush();
            outputStream.close();
            int responseCode = connection.getResponseCode();
            System.out.println("response code:"+responseCode);
            InputStream inputStream = connection.getInputStream();
            JsonReader jsonReader = Json.createReader(inputStream);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            System.out.println("Json:"+jsonObject);
            boolean success= jsonObject.getBoolean("success");
            return success;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
