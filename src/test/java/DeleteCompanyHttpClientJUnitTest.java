import com.era.httpclient.DeleteCompanyHttpClient;
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
public class DeleteCompanyHttpClientJUnitTest  {
    
    @Test
    @Order(1)
    public void updateCompanyHttpClientTest() {
        
        try{
            
            DeleteCompanyHttpClient DeleteCompanyHttpClient = new DeleteCompanyHttpClient();
            DeleteCompanyHttpClient.setCompanyCode("1576973977812");
            DeleteCompanyHttpClient.setDeleteCompanySubscriberInterface(() -> {
                Assertions.assertTrue(true);
            });
            DeleteCompanyHttpClient.setErrorCodeSubscriberInterface((String code) -> {
                LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error " + code);
                Assertions.fail();
            });                    
            DeleteCompanyHttpClient.execute();
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(UpdateCompanyHttpClientJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
