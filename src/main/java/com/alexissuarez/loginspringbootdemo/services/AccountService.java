/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.services;

import com.alexissuarez.loginspringbootdemo.dao.AccountDao;
import com.alexissuarez.loginspringbootdemo.dto.LoginDto;
import com.alexissuarez.loginspringbootdemo.dto.RegisterDto;
import com.alexissuarez.loginspringbootdemo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexis
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountDao accountDao;
    
    public boolean login(LoginDto dto) {
        User u = accountDao.login(dto);
        return u != null;
    }
    
    public User register(RegisterDto dto) {
        return accountDao.register(dto);
    }
}
