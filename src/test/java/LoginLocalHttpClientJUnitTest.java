import com.era.httpclient.LoginLocalHttpClient;
import com.era.httpclient.responses.LoginLocalResponseRequestModel;
import com.era.httpclient.subscriber.LoginSubscriberInterface;
import com.era.logger.LoggerUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
@TestMethodOrder(OrderAnnotation.class)
public class LoginLocalHttpClientJUnitTest  {
    
    @Test
    @Order(1)
    public void updateCompanyHttpClientTest() {
        
        try{
            
            LoginLocalHttpClient LoginLocalHttpClient = new LoginLocalHttpClient();
            LoginLocalHttpClient.setLoginSubscriberInterface(new LoginSubscriberInterface() {

                @Override
                public void OnLoginCorrect(LoginLocalResponseRequestModel LoginLocalResponseRequestModel) {
                    
                    LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service responded login valid");
                    Assertions.assertTrue(true);
                }

                @Override
                public void OnInvalidLogin() {
                    
                    LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error invalid credentials");
                    Assertions.fail();
                }

                @Override
                public void OnUserNotExists() {
                    
                    LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error user not exists");
                    Assertions.fail();
                }
            });
            LoginLocalHttpClient.setErrorCodeSubscriberInterface((String code) -> {
                
                LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error " + code);
                Assertions.fail();
            });                    
            LoginLocalHttpClient.execute();
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(UpdateCompanyHttpClientJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
