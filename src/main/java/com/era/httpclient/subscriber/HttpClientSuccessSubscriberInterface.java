/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient.subscriber;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author PC
 */
public interface HttpClientSuccessSubscriberInterface {
    public void OnSuccess(CloseableHttpResponse CloseableHttpResponse, String result) throws Exception;
}
