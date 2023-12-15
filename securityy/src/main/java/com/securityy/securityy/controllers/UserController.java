package com.securityy.securityy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    
    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/dash")
    public String userdash(){
        return "userdashboard";
    }
}
