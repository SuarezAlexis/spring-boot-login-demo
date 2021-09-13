/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.controllers;

import com.alexissuarez.loginspringbootdemo.dto.LoginDto;
import com.alexissuarez.loginspringbootdemo.dto.RegisterDto;
import com.alexissuarez.loginspringbootdemo.services.AccountService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alexis
 */
@Controller
public class LoginController {
    
    @Autowired
    AccountService accountService;
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message","Hello from Thymeleaf");
        return "index";
    }
    
    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerForm(Model model) {
        return "register";
    }
    
    @PostMapping("/login")
    public String login(Model model, LoginDto dto) {
        model.addAttribute("message","Hello " + dto.getUsername() + "!");
        model.addAttribute("logged",accountService.login(dto));
        return "index";
    }
    
    @PostMapping("/register")
    public String register(Model model, RegisterDto dto) {
        
        return "index";
    }
}
