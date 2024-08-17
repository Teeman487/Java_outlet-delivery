package com.java_outletdelivery.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class AuthController {

    // Restaurant login form
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

}
