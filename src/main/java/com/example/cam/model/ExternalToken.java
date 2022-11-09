package com.example.cam.model;

import lombok.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@Data
public class ExternalToken implements Serializable {
    String header;
    String body;
    String signature;

    private String base64Encode(String input){
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public String getToken(){
        this.setHeader("{ \"alg\" : \"HS256\", \"typ\": \"EAT\"}");
        this.setBody("{\"sub\" : \"1234567898\", \"name\" : \"John Doe\", \"iat\": \""+ getTokenTime()+ "\" }");
        this.setSignature("externalTestSignature");
        return base64Encode(header)+"."+
                base64Encode(body)+"."+
                base64Encode(signature);
    };
    private String getTokenTime(){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.MINUTE, 60);
        return String.valueOf(cal.getTimeInMillis());
    }
}
