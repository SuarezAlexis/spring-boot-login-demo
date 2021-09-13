/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.services;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Alexis
 */
public class CustomAuthFilter extends GenericFilterBean {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if( auth == null || !auth.isAuthenticated() ){
            if( request instanceof HttpServletRequest ) {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                if( httpRequest.getMethod().equals("POST") && httpRequest.getServletPath().equals("/login")) {
                    System.out.println("LOGIN ATTEMPT");
                }
            }
        }
        chain.doFilter(request, response);
    }
}
