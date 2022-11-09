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
        return eatToken.getToken();
    }

    @GetMapping("/iat")
    public String getIat() {
        InternalToken iatToken = new InternalToken();
        return iatToken.getToken();
    }
}
