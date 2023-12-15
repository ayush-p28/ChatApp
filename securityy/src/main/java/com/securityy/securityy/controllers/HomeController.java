package com.securityy.securityy.controllers;

import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("Yes, I am a public User");
    }

    // @PreAuthorize("hasRole('NORMAL')") can be used in place of securityConfig configerations..but we have to apply @EnableMethodSecurity
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("Yes, I am a normal User");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("Yes, I am a admin User");
    }
    
}