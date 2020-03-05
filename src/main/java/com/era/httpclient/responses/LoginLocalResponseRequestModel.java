/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient.responses;

import com.era.datamodels.ComputerLicenseDataModel;

/**
 *
 * @author PC
 */
public class LoginLocalResponseRequestModel extends ResponseRequestModel {
    
    private ComputerLicenseDataModel ComputerLicenseDataModel;

    public ComputerLicenseDataModel getComputerLicenseDataModel() {
        return ComputerLicenseDataModel;
    }

    public void setComputerLicenseDataModel(ComputerLicenseDataModel ComputerLicenseDataModel) {
        this.ComputerLicenseDataModel = ComputerLicenseDataModel;
    }
}
