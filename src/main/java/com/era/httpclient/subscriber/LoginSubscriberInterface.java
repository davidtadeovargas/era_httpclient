/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient.subscriber;

import com.era.httpclient.responses.LoginLocalResponseRequestModel;

/**
 *
 * @author PC
 */
public interface LoginSubscriberInterface extends BaseSubscribersInterface {
    public void OnLoginCorrect(LoginLocalResponseRequestModel LoginLocalResponseRequestModel);
    public void OnInvalidLogin();
    public void OnUserNotExists();
}
