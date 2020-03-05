import com.era.datamodels.ComputerLicenseDataModel;
import com.era.httpclient.GetComputerStatusHttpClient;
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
public class GetComputerStatusHttpClientJUnitTest  {
    
    @Test
    @Order(1)
    public void updateCompanyHttpClientTest() {
        
        try{
            
            GetComputerStatusHttpClient GetComputerStatusHttpClient = new GetComputerStatusHttpClient();            
            GetComputerStatusHttpClient.setGetComputerStatusSubscriberInteface((ComputerLicenseDataModel ComputerLicenseDataModel) -> {
                
                LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service returned ComputerLicenseDataModel " + ComputerLicenseDataModel);
                
                Assertions.assertTrue(true);
            });
            GetComputerStatusHttpClient.setErrorCodeSubscriberInterface((String code) -> {
                LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error " + code);
                Assertions.fail();
            });                    
            GetComputerStatusHttpClient.execute();
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(UpdateCompanyHttpClientJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
