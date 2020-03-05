import com.era.httpclient.UpdateCompanyHttpClient;
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
public class UpdateCompanyHttpClientJUnitTest  {
    
    @Test
    @Order(1)
    public void updateCompanyHttpClientTest() {
        
        try{
            
            UpdateCompanyHttpClient UpdateCompanyHttpClient = new UpdateCompanyHttpClient();
            UpdateCompanyHttpClient.setCompanyCode(Long.toString(System.currentTimeMillis()));            
            UpdateCompanyHttpClient.setName(Long.toString(System.currentTimeMillis()));
            UpdateCompanyHttpClient.setCompanyDB("dbtest100");
            UpdateCompanyHttpClient.setCostMethod("ueps");
            UpdateCompanyHttpClient.setPhone("33151064492");
            UpdateCompanyHttpClient.setPhoneDeliver("33151064492");
            UpdateCompanyHttpClient.setCelen("33151064492");
            UpdateCompanyHttpClient.setPersonalPhone1("33151064492");
            UpdateCompanyHttpClient.setPersonalPhone2("33151064492");
            UpdateCompanyHttpClient.setStreet("mi calle");
            UpdateCompanyHttpClient.setLadaDeliver("");
            UpdateCompanyHttpClient.setMoralOrPhisic("F");            
            UpdateCompanyHttpClient.setContactDeliver1("");
            UpdateCompanyHttpClient.setEstation("ESTAC1");            
            UpdateCompanyHttpClient.setContactDeliver2("");
            UpdateCompanyHttpClient.setContactDeliver3("");
            UpdateCompanyHttpClient.setStreetDeliver("mi calle");
            UpdateCompanyHttpClient.setInteriorNumber("-12");
            UpdateCompanyHttpClient.setInteriorNumberDeliver("-12");
            UpdateCompanyHttpClient.setExternalNumber("100");
            UpdateCompanyHttpClient.setExternalNumberDeliver("100");
            UpdateCompanyHttpClient.setColony("ATLAS");
            UpdateCompanyHttpClient.setColonyDeliver("ATLAS");
            UpdateCompanyHttpClient.setCity("GUADALAJARA");
            UpdateCompanyHttpClient.setCityDeliver("GUADALAJARA");
            UpdateCompanyHttpClient.setEstate("JALISCO");
            UpdateCompanyHttpClient.setEstateDeliver("JALISCO");
            UpdateCompanyHttpClient.setCountry("MEXICO");
            UpdateCompanyHttpClient.setCountryDeliver("MEXICO");
            UpdateCompanyHttpClient.setRfc(Long.toString(System.currentTimeMillis()));
            UpdateCompanyHttpClient.setEmail("coritocorito@hotmail.com");
            UpdateCompanyHttpClient.setWebsite("www.google.com");            
            UpdateCompanyHttpClient.setExpedPlace("GUADALAJARA");
            UpdateCompanyHttpClient.setFiscalRegimen("");
            UpdateCompanyHttpClient.setPathCert("");
            UpdateCompanyHttpClient.setPathCertKey("");
            UpdateCompanyHttpClient.setCertificatePassword("");
            UpdateCompanyHttpClient.setCp("100");
            UpdateCompanyHttpClient.setCpDeliver("1000");
            UpdateCompanyHttpClient.setTemplate("");
            UpdateCompanyHttpClient.setAppPath("");
            UpdateCompanyHttpClient.setSucursal("SUC1");
            UpdateCompanyHttpClient.setExtension("1001");
            UpdateCompanyHttpClient.setCashNumber("CAJ1");
            UpdateCompanyHttpClient.setUpdateCompanyHttpInterface(() -> {
                Assertions.assertTrue(true);
            });
            UpdateCompanyHttpClient.setErrorCodeSubscriberInterface((String code) -> {
                LoggerUtility.getSingleton().logInfo(UpdateCompanyHttpClientJUnitTest.class, "Web service failed with error " + code);
                Assertions.fail();
            });                    
            UpdateCompanyHttpClient.execute();
            
        }catch(Exception e){
            LoggerUtility.getSingleton().logError(UpdateCompanyHttpClientJUnitTest.class, e);
            
            Assertions.fail();
        }
    }
}
