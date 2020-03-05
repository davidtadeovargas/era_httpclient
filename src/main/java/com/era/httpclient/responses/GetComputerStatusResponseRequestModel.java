/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient.responses;

import com.era.datamodels.PremiumFuntionsDataModel;
import com.era.datamodels.TestCompanyDataModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author PC
 */
public class GetComputerStatusResponseRequestModel extends ResponseRequestModel{
    
    private String email;
    private String name;
    private String channel;
    private String serie;
    private int numberComputers;
    private String computerCreatedAt;
    private int remainingDays;
    private String genericSerial;
    
    @JsonProperty("PremiumFuntionsDataModel")
    private PremiumFuntionsDataModel PremiumFuntionsDataModel;    
    
    @JsonProperty("TestCompanyDataModel")
    private TestCompanyDataModel TestCompanyDataModel;

    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumberComputers() {
        return numberComputers;
    }

    public void setNumberComputers(int numberComputers) {
        this.numberComputers = numberComputers;
    }

    public String getComputerCreatedAt() {
        return computerCreatedAt;
    }

    public void setComputerCreatedAt(String computerCreatedAt) {
        this.computerCreatedAt = computerCreatedAt;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public String getGenericSerial() {
        return genericSerial;
    }

    public void setGenericSerial(String genericSerial) {
        this.genericSerial = genericSerial;
    }

    public PremiumFuntionsDataModel getPremiumFuntionsDataModel() {
        return PremiumFuntionsDataModel;
    }

    public void setPremiumFuntionsDataModel(PremiumFuntionsDataModel PremiumFuntionsDataModel) {
        this.PremiumFuntionsDataModel = PremiumFuntionsDataModel;
    }

    public TestCompanyDataModel getTestCompanyDataModel() {
        return TestCompanyDataModel;
    }

    public void setTestCompanyDataModel(TestCompanyDataModel TestCompanyDataModel) {
        this.TestCompanyDataModel = TestCompanyDataModel;
    }
}
