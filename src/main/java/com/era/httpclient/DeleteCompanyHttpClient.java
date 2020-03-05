/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.httpclient.requests.DeleteCompanyRequestModel;
import com.era.httpclient.responses.DeleteCompanyResponseRequestModel;
import com.era.httpclient.subscriber.DeleteCompanySubscriberInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author PC
 */
public class DeleteCompanyHttpClient extends BaseHttpClient{
    
    private String companyCode;
    
    private DeleteCompanySubscriberInterface DeleteCompanySubscriberInterface;
    
    
    public DeleteCompanyHttpClient(){
        
        //Call parent constructor
        super();
        
        //Set the endpoint
        this.BaseHttpClientManager.setEndpoint("delete_company");
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }    

    public void setDeleteCompanySubscriberInterface(DeleteCompanySubscriberInterface DeleteCompanySubscriberInterface) {
        this.DeleteCompanySubscriberInterface = DeleteCompanySubscriberInterface;
    }
    
    @Override
    public void execute() throws Exception {
        
        //Create the base request model
        final DeleteCompanyRequestModel DeleteCompanyRequestModel = new DeleteCompanyRequestModel();
        DeleteCompanyRequestModel.setCompanyCode(companyCode);
        
        //Asign the request model to the manage
        this.BaseHttpClientManager.setBaseRequestModel(DeleteCompanyRequestModel);
        
        //Subscribe to success event
        this.BaseHttpClientManager.setHttpClientSuccessSubscriberInterface((CloseableHttpResponse CloseableHttpResponse,String result) -> {
            
            //If subscribers for login
            if(DeleteCompanySubscriberInterface!=null){
                
                final HttpEntity entity = CloseableHttpResponse.getEntity();
                if(entity!=null){
                    
                    //Get the response object                    
                    final ObjectMapper mapper = new ObjectMapper();
                    final DeleteCompanyResponseRequestModel DeleteCompanyResponseRequestModel = mapper.readValue(result, DeleteCompanyResponseRequestModel.class);
                    
                    //If login is ok
                    if("ok".equals(DeleteCompanyResponseRequestModel.getResponseStatus())){
                        DeleteCompanySubscriberInterface.OnCompanyDeleted();
                    }
                    else{
                        if(ErrorCodeSubscriberInterface!=null){
                            ErrorCodeSubscriberInterface.onError(DeleteCompanyResponseRequestModel.getErrorCode());
                        }
                    }
                }
            }
        });
                
        //Execute the request
        this.BaseHttpClientManager.executePost();                
    }
}
