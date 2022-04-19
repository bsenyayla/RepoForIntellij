package edu.mum.cs245.eregistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
@RequestMapping(value = {"","/eregistrar"})
public class HomePageController {

    @GetMapping(value = {"/","/home"})
    public String displayHomePage() {
        return "public/home/index";
    }

}
