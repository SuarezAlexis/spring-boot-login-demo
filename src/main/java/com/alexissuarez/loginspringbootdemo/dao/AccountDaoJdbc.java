/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexissuarez.loginspringbootdemo.dao;

import com.alexissuarez.loginspringbootdemo.dto.LoginDto;
import com.alexissuarez.loginspringbootdemo.dto.RegisterDto;
import com.alexissuarez.loginspringbootdemo.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alexis
 */
@Component("accountDao")
public class AccountDaoJdbc implements AccountDao {

    private final static String USER_QUERY = "SELECT * FROM Usuarios WHERE username = ? OR email = ?";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private final static RowMapper rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User u = new User();
            u.setEmail(rs.getString("email"));
            u.setUsername(rs.getString("username"));
            return u;
        }
    };
    
    @Override
    public User register(RegisterDto dto) {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder(10);
        String encoded = pe.encode(dto.getPassword());
        return new User();
    }

    @Override
    public User login(LoginDto dto) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(USER_QUERY);
                ps.setString(1, dto.getUsername());
                ps.setString(2, dto.getUsername());
                return ps;
            }
        };
        return (User) jdbcTemplate.query(psc, rowMapper).get(0);
    }

    @Override
    public User findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(String query) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(USER_QUERY);
                ps.setString(1, query);
                ps.setString(2, query);
                return ps;
            }
        };
        return (User) jdbcTemplate.query(psc, rowMapper).get(0);
    }

    @Override
    public User delete(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(RegisterDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
