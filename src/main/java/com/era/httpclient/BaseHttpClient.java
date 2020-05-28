/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.httpclient.subscriber.ErrorCodeSubscriberInterface;
import com.era.httpclient.subscriber.HttpClientErrorSubscriberInterface;

/**
 *
 * @author PC
 */
public abstract class BaseHttpClient {
 
    protected BaseHttpClientManager BaseHttpClientManager = new BaseHttpClientManager();
    protected ErrorCodeSubscriberInterface ErrorCodeSubscriberInterface;
    protected ErrorInPetition ErrorInPetition;
    
    
    
    public BaseHttpClient(){
        BaseHttpClientManager.setHttpClientErrorSubscriberInterface(new HttpClientErrorSubscriberInterface(){
            @Override
            public void OnException(Exception Exception) {
                if(ErrorInPetition != null){
                    ErrorInPetition.onError(Exception);
                }                
            }
            @Override
            public void OnUnknownError() {
            }
        });
    }

    public void setErrorInPetition(ErrorInPetition ErrorInPetition) {
        this.ErrorInPetition = ErrorInPetition;
    }
    
    public abstract void execute() throws Exception;

    public BaseHttpClientManager getBaseHttpClientManager() {
        return BaseHttpClientManager;
    }

    public void setBaseHttpClientManager(BaseHttpClientManager BaseHttpClientManager) {
        this.BaseHttpClientManager = BaseHttpClientManager;
    }

    public ErrorCodeSubscriberInterface getErrorCodeSubscriberInterface() {
        return ErrorCodeSubscriberInterface;
    }

    public void setErrorCodeSubscriberInterface(ErrorCodeSubscriberInterface ErrorCodeSubscriberInterface) {
        this.ErrorCodeSubscriberInterface = ErrorCodeSubscriberInterface;
    }
    
    public interface ErrorInPetition{
        public void onError(Exception Exception);
    }
}
