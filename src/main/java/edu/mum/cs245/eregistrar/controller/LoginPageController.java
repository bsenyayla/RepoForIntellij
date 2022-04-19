package edu.mum.cs245.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping(path = {"/public/login", "/eregistrar/public/login"})
    public String displayLoginPage(){
        return "public/home/login";
    }
}
