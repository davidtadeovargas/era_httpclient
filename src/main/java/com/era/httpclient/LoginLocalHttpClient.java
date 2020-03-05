/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.httpclient.requests.LoginRequestModel;
import com.era.httpclient.responses.LoginLocalResponseRequestModel;
import com.era.httpclient.subscriber.LoginSubscriberInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author PC
 */
public class LoginLocalHttpClient extends BaseHttpClient {

    private LoginSubscriberInterface LoginSubscriberInterface;
    
    private String user;
    private String password;
    
    
    public LoginLocalHttpClient(){
        
        //Call parent constructor
        super();
        
        //Set the endpoint
        this.BaseHttpClientManager.setEndpoint("login_local");
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    public void setLoginSubscriberInterface(LoginSubscriberInterface LoginSubscriberInterface) {
        this.LoginSubscriberInterface = LoginSubscriberInterface;
    }
    
    @Override
    public void execute() throws Exception {
        
        //Create the base request model
        final LoginRequestModel LoginRequestModel = new LoginRequestModel();
        
        //Asign the request model to the manage
        this.BaseHttpClientManager.setBaseRequestModel(LoginRequestModel);
        
        //Set user and password
        LoginRequestModel.setUser(user);
        LoginRequestModel.setPassword(password);
        
        //Subscribe to success event
        this.BaseHttpClientManager.setHttpClientSuccessSubscriberInterface((CloseableHttpResponse CloseableHttpResponse,String result) -> {
            
            //If subscribers for login
            if(LoginSubscriberInterface!=null){
                
                final HttpEntity entity = CloseableHttpResponse.getEntity();
                if(entity!=null){
                    
                    ObjectMapper mapper = new ObjectMapper();
                    LoginLocalResponseRequestModel LoginLocalResponseRequestModel = mapper.readValue(result, LoginLocalResponseRequestModel.class);                                        
                        
                    //If login is ok
                    if("ok".equals(LoginLocalResponseRequestModel.getResponseStatus())){
                        LoginSubscriberInterface.OnLoginCorrect(LoginLocalResponseRequestModel);
                    }
                    else if("USER_NOT_EXISTS_ERROR".equals(LoginLocalResponseRequestModel.getErrorCode())){
                        LoginSubscriberInterface.OnUserNotExists();
                    }
                    else if("INVALID_LOGIN_ERROR".equals(LoginLocalResponseRequestModel.getErrorCode())){
                        LoginSubscriberInterface.OnInvalidLogin();
                    }
                    else {
                        if(ErrorCodeSubscriberInterface!=null){
                            ErrorCodeSubscriberInterface.onError(LoginLocalResponseRequestModel.getErrorCode());
                        }
                    }
                }
            }
        });
                
        //Execute the request
        this.BaseHttpClientManager.executePost();
    }
}
