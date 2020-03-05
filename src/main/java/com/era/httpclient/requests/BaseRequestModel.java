/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient.requests;

/**
 *
 * @author PC
 */
public class BaseRequestModel {
    
    private String user;
    private String password;
    private String token;
    private String computerIDD;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getComputerIDD() {
        return computerIDD;
    }

    public void setComputerIDD(String computerIDD) {
        this.computerIDD = computerIDD;
    }
}
