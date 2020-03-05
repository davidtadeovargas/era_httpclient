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
public class GetComputerStatusRequestModel extends BaseRequestModel {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
