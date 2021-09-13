/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.dao;

import com.alexissuarez.loginspringbootdemo.dto.LoginDto;
import com.alexissuarez.loginspringbootdemo.dto.RegisterDto;
import com.alexissuarez.loginspringbootdemo.models.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexis
 */
public interface AccountDao {
    public User register(RegisterDto dto);
    public User login(LoginDto dto);
    public User findAll();
    public User find(String query);
    public User delete(String username);
    public User update(RegisterDto dto);
}
