/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.services;

import com.alexissuarez.loginspringbootdemo.dao.AccountDao;
import com.alexissuarez.loginspringbootdemo.models.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Alexis
 */
public class CustomAuthentication implements Authentication {

    @Autowired
    private AccountDao accountDao;
    
    private User principal;
    private boolean authenticated = false;
    private List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    
    public CustomAuthentication(){}
    public CustomAuthentication(User u) {
        this();
        principal = u;
        authenticated = true;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getDetails() {
        return this.getClass();
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean bln) throws IllegalArgumentException {
        authenticated = bln;
    }

    @Override
    public String getName() {
        return principal.getUsername();
    }
    
}
