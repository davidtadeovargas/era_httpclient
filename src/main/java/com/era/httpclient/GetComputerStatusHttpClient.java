/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.datamodels.ComputerLicenseDataModel;
import com.era.httpclient.requests.GetComputerStatusRequestModel;
import com.era.httpclient.responses.GetComputerStatusResponseRequestModel;
import com.era.httpclient.subscriber.GetComputerStatusSubscriberInteface;
import com.era.utilities.BaseUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author PC
 */
 public class GetComputerStatusHttpClient extends BaseHttpClient{
    
    private GetComputerStatusSubscriberInteface GetComputerStatusSubscriberInteface;
  
    private String user;
    private String password;
    
    public GetComputerStatusHttpClient(){
        
        //Call parent constructor
        super();
        
        //Set the endpoint
        this.BaseHttpClientManager.setEndpoint("get_computer_status");
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setGetComputerStatusSubscriberInteface(GetComputerStatusSubscriberInteface GetComputerStatusSubscriberInteface) {
        this.GetComputerStatusSubscriberInteface = GetComputerStatusSubscriberInteface;
    }
            
    @Override
    public void execute() throws Exception {
        
        //Get computer name
        final String computerName = new BaseUtility().getPCName();
        
        //Create the base request model
        final GetComputerStatusRequestModel GetComputerStatusRequestModel = new GetComputerStatusRequestModel();                
        GetComputerStatusRequestModel.setName(computerName);
        
        //Set user name and password
        GetComputerStatusRequestModel.setUser(user);
        GetComputerStatusRequestModel.setPassword(password);
        
        //Asign the request model to the manage
        this.BaseHttpClientManager.setBaseRequestModel(GetComputerStatusRequestModel);                
        
        //Subscribe to success event
        this.BaseHttpClientManager.setHttpClientSuccessSubscriberInterface((CloseableHttpResponse CloseableHttpResponse,String result) -> {
            
            //If subscribers for login
            if(GetComputerStatusSubscriberInteface!=null){
                
                final HttpEntity entity = CloseableHttpResponse.getEntity();
                if(entity!=null){
                    
                    //Get the response object                    
                    ObjectMapper mapper = new ObjectMapper();
                    GetComputerStatusResponseRequestModel GetComputerStatusResponseRequestModel = mapper.readValue(result, GetComputerStatusResponseRequestModel.class);
                    
                    //Create the result model
                    final ComputerLicenseDataModel ComputerLicenseDataModel = new ComputerLicenseDataModel();
                    ComputerLicenseDataModel.setEmail(GetComputerStatusResponseRequestModel.getEmail());
                    ComputerLicenseDataModel.setName(GetComputerStatusResponseRequestModel.getName());
                    ComputerLicenseDataModel.setSerie(GetComputerStatusResponseRequestModel.getSerie());
                    ComputerLicenseDataModel.setNumberComputers(GetComputerStatusResponseRequestModel.getNumberComputers());
                    ComputerLicenseDataModel.setCreated_at(GetComputerStatusResponseRequestModel.getComputerCreatedAt());
                    ComputerLicenseDataModel.setChannel(GetComputerStatusResponseRequestModel.getChannel());
                    ComputerLicenseDataModel.setRemainingDays(GetComputerStatusResponseRequestModel.getRemainingDays());
                    ComputerLicenseDataModel.setGenericSerial(GetComputerStatusResponseRequestModel.getGenericSerial());
                    ComputerLicenseDataModel.setPremiumFuntionsDataModel(GetComputerStatusResponseRequestModel.getPremiumFuntionsDataModel());
                    ComputerLicenseDataModel.setTestCompanyDataModel(GetComputerStatusResponseRequestModel.getTestCompanyDataModel());
                                                            
                    //If login is ok
                    if("ok".equals(GetComputerStatusResponseRequestModel.getResponseStatus())){
                        GetComputerStatusSubscriberInteface.OnResponse(ComputerLicenseDataModel);
                    }
                    else{
                        if(ErrorCodeSubscriberInterface!=null){
                            ErrorCodeSubscriberInterface.onError(GetComputerStatusResponseRequestModel.getErrorCode());
                        }                        
                    }
                }
            }
        });
                
        //Execute the request
        this.BaseHttpClientManager.executePost();
    }
}
