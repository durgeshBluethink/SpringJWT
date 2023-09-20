package com.security.springSecurity.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@PreAuthorize("hasRole('Normal')")
@RestController
@RequestMapping("/public")
public class HomeController {


    @RequestMapping("/home")
    public String home(){
        return "this is my home page";
    }
    @RequestMapping("/login")
    public String login(){
        return "this is my login page";
    }
    @RequestMapping("/register")
    public String register(){
        return "this is my register page";
    }

}
