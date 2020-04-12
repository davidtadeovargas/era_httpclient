/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.datamodels.TokenConfigDataModel;
import com.era.httpclient.exceptions.NoRequestModelProvicedException;
import com.era.httpclient.requests.BaseRequestModel;
import com.era.httpclient.subscriber.HttpClientErrorSubscriberInterface;
import com.era.httpclient.subscriber.HttpClientSuccessSubscriberInterface;
import com.era.logger.LoggerUtility;
import com.era.models.License;
import com.era.repositories.RepositoryFactory;
import com.era.utilities.SystemMotherBoardNumber;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author PC
 */
public class BaseHttpClientManager {
    
    private final String server = "http://localhost"; //http://easyretail.com.mx //http://localhost
    private String endpoint;
    private HttpEntityEnclosingRequestBase HttpMethod;
    private BaseRequestModel BaseRequestModel;
    private CloseableHttpResponse CloseableHttpResponse;
    private Exception Exception;
    
    private HttpClientErrorSubscriberInterface HttpClientErrorSubscriberInterface;
    private HttpClientSuccessSubscriberInterface HttpClientSuccessSubscriberInterface;    
    
    private String finalServerURL;
    private CloseableHttpClient client;
    private String jsonInString;
    private ObjectMapper mapper;

    
    
    
    
    public void setHttpClientErrorSubscriberInterface(HttpClientErrorSubscriberInterface HttpClientErrorSubscriberInterface) {
        this.HttpClientErrorSubscriberInterface = HttpClientErrorSubscriberInterface;
    }

    public void setHttpClientSuccessSubscriberInterface(HttpClientSuccessSubscriberInterface HttpClientSuccessSubscriberInterface) {
        this.HttpClientSuccessSubscriberInterface = HttpClientSuccessSubscriberInterface;
    }
        
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setBaseRequestModel(BaseRequestModel BaseRequestModel) {
        this.BaseRequestModel = BaseRequestModel;
    }

    public void executePost() throws Exception {
        
        this.initExecute();
        
        //Init post
        HttpMethod = new HttpPost(finalServerURL);
                
        LoggerUtility.getSingleton().logInfo(BaseHttpClientManager.class, "BaseHttpClientManager: executePost to " + finalServerURL);        
                
        this.endExecute();
    }
    
    private void initExecute() throws Exception {
        
        //Validate that the base models has memory
        if(BaseRequestModel==null){
           throw new NoRequestModelProvicedException(); 
        }        
        
        //Set the token for the API
        BaseRequestModel.setToken(new TokenConfigDataModel().getToken());
        
        //Set the user and password
        if(BaseRequestModel.getUser()==null){
            final License License = RepositoryFactory.getInstance().getLicenseRepository().getLicense();
            if(License!=null){
                BaseRequestModel.setUser(License.getUser());
                BaseRequestModel.setPassword(License.getPassword());
            }
        }        
        
        //Get the computer ID
        final String computerIDD = SystemMotherBoardNumber.getWindowsMotherboard_SerialNumber();
        
        //Set the computerIDD
        BaseRequestModel.setComputerIDD(computerIDD);
        
        //Convert the BaseRequestModel to json
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        jsonInString = mapper.writeValueAsString(BaseRequestModel);
        
        //Final server url
        finalServerURL = server + "/" + endpoint;
        
        LoggerUtility.getSingleton().logInfo(BaseHttpClientManager.class,"BaseHttpClientManager: initExecute");
        
        LoggerUtility.getSingleton().logInfo(BaseHttpClientManager.class,"BaseHttpClientManager: initExecute finalServerURL = " + finalServerURL);
                
        //Create the connection
        client = HttpClients.createDefault();
    }
    
    private void endExecute() throws Exception {
        
        //Set the entity
        HttpMethod.setEntity(new StringEntity(jsonInString));
        
        //Set headers
        HttpMethod.setHeader("Content-type", "application/json");
        
        try{
            
            //Run the connection and wait for response
            CloseableHttpResponse = client.execute(HttpMethod);
            
            //Get the response object
            final HttpEntity entity = CloseableHttpResponse.getEntity();
            if(entity!=null){
                
                String result = EntityUtils.toString(entity);

                LoggerUtility.getSingleton().logInfo(BaseHttpClientManager.class, "BaseHttpClientManager: Server response result = " + result);
                
                //If there are subscribers send the result
                if(HttpClientSuccessSubscriberInterface != null){
                    HttpClientSuccessSubscriberInterface.OnSuccess(CloseableHttpResponse,result);
                }            
            }
            
        }catch(Exception e){
            
            //If any try catch exception save the exception in Exception global class
            Exception = e;
            
            LoggerUtility.getSingleton().logError(BaseHttpClientManager.class, e);
            
            //If there are subscribers
            if(HttpClientErrorSubscriberInterface != null){
                HttpClientErrorSubscriberInterface.OnException(Exception);
            }
        }
    }
}
