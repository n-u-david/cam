package com.example.cam.controller;

import com.example.cam.model.ExternalToken;
import com.example.cam.model.InternalToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.sql.Timestamp;

@RestController
public class TokenController {

    @GetMapping("/eat")
    public String getEat() {
        ExternalToken eatToken = new ExternalToken();
        eatToken.setHeader("{ \"alg\" : \"HS256\", \"typ\": \"EAT\"}");
        eatToken.setBody("{\"sub\" : \"1234567898\", \"name\" : \"John Doe\", \"iat\": \""+ getTokenTime()+ "\" }");
        eatToken.setSignature("testSignature");

        return base64Encode(eatToken.getHeader())+"."+
                base64Encode(eatToken.getBody())+"."+
                base64Encode(eatToken.getSignature());
    }

    @GetMapping("/iat")
    public String getIat() {
        InternalToken iatToken = new InternalToken();
        iatToken.setHeader("{ \"alg\" : \"HS256\", \"typ\": \"IAT\"}");
        iatToken.setBody("{\"sub\" : \"1234567898\", \"name\" : \"John Doe\", \"iat\": \""+ getTokenTime()+ "\" }");
        iatToken.setSignature("testSignature");

        return base64Encode(iatToken.getHeader())+"."+
                base64Encode(iatToken.getBody())+"."+
                base64Encode(iatToken.getSignature());
    }

    private String getTokenTime(){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.MINUTE, 60);
        return String.valueOf(cal.getTimeInMillis());
    }

    private String base64Encode(String input){
        return Base64.getEncoder().encodeToString(input.getBytes());
    }
}
