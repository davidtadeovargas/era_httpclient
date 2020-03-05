/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.era.httpclient;

import com.era.httpclient.requests.UpdateCompanyRequestModel;
import com.era.httpclient.responses.UpdateCompanyResponseRequestModel;
import com.era.httpclient.subscriber.UpdateCompanySubscriberInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author PC
 */
public class UpdateCompanyHttpClient extends BaseHttpClient {
    
    private String name;
    private String companyCode;
    private String phone;
    private String phoneDeliver;
    private String expedPlace;
    private String personalPhone1;
    private String personalPhone2;
    private String street;
    private String celen;
    private String certificatePassword;
    private String streetDeliver;
    private String colony;
    private String colonyDeliver;
    private String ladaDeliver;
    private String cp;
    private String cpDeliver;
    private String city;
    private String cityDeliver;
    private String estate;
    private String contactDeliver3;
    private String contactDeliver2;
    private String contactDeliver1;
    private String estateDeliver;
    private String country;
    private String countryDeliver;
    private String rfc;
    private String email;
    private String website;
    private String interiorNumber;
    private String interiorNumberDeliver;
    private String externalNumber;
    private String pathCert;
    private String externalNumberDeliver;
    private String pathCertKey;
    private String moralOrPhisic;
    private String estation;
    private String appPath;
    private String sucursal;
    private String cashNumber;
    private String companyDB;
    private String costMethod;
    private String extension;
    private String fiscalRegimen;
    private String template;
    
    
    private UpdateCompanySubscriberInterface UpdateCompanyHttpInterface;    
    
    
    
    public UpdateCompanyHttpClient(){
        
        //Call parent constructor
        super();
        
        //Set the endpoint
        this.BaseHttpClientManager.setEndpoint("add_or_update_company");
    }

    public void setCompanyDB(String companyDB) {
        this.companyDB = companyDB;
    }

    public void setCostMethod(String costMethod) {
        this.costMethod = costMethod;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setFiscalRegimen(String fiscalRegimen) {
        this.fiscalRegimen = fiscalRegimen;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoneDeliver(String phoneDeliver) {
        this.phoneDeliver = phoneDeliver;
    }

    public void setExpedPlace(String expedPlace) {
        this.expedPlace = expedPlace;
    }

    public void setPersonalPhone1(String personalPhone1) {
        this.personalPhone1 = personalPhone1;
    }

    public void setPersonalPhone2(String personalPhone2) {
        this.personalPhone2 = personalPhone2;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCelen(String celen) {
        this.celen = celen;
    }

    public void setCertificatePassword(String certificatePassword) {
        this.certificatePassword = certificatePassword;
    }

    public void setStreetDeliver(String streetDeliver) {
        this.streetDeliver = streetDeliver;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public void setColonyDeliver(String colonyDeliver) {
        this.colonyDeliver = colonyDeliver;
    }

    public void setLadaDeliver(String ladaDeliver) {
        this.ladaDeliver = ladaDeliver;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setCpDeliver(String cpDeliver) {
        this.cpDeliver = cpDeliver;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityDeliver(String cityDeliver) {
        this.cityDeliver = cityDeliver;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public void setContactDeliver3(String contactDeliver3) {
        this.contactDeliver3 = contactDeliver3;
    }

    public void setContactDeliver2(String contactDeliver2) {
        this.contactDeliver2 = contactDeliver2;
    }

    public void setContactDeliver1(String contactDeliver1) {
        this.contactDeliver1 = contactDeliver1;
    }

    public void setEstateDeliver(String estateDeliver) {
        this.estateDeliver = estateDeliver;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryDeliver(String countryDeliver) {
        this.countryDeliver = countryDeliver;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setInteriorNumber(String interiorNumber) {
        this.interiorNumber = interiorNumber;
    }

    public void setInteriorNumberDeliver(String interiorNumberDeliver) {
        this.interiorNumberDeliver = interiorNumberDeliver;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber;
    }

    public void setPathCert(String pathCert) {
        this.pathCert = pathCert;
    }

    public void setExternalNumberDeliver(String externalNumberDeliver) {
        this.externalNumberDeliver = externalNumberDeliver;
    }

    public void setPathCertKey(String pathCertKey) {
        this.pathCertKey = pathCertKey;
    }

    public void setMoralOrPhisic(String moralOrPhisic) {
        this.moralOrPhisic = moralOrPhisic;
    }

    public void setEstation(String estation) {
        this.estation = estation;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void setCashNumber(String cashNumber) {
        this.cashNumber = cashNumber;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setUpdateCompanyHttpInterface(UpdateCompanySubscriberInterface UpdateCompanyHttpInterface) {
        this.UpdateCompanyHttpInterface = UpdateCompanyHttpInterface;
    }
           
    @Override
    public void execute() throws Exception {
        
        //Create the base request model
        final UpdateCompanyRequestModel UpdateCompanyRequestModel = new UpdateCompanyRequestModel();
        UpdateCompanyRequestModel.setName(name);
        UpdateCompanyRequestModel.setCompanyCode(companyCode);
        UpdateCompanyRequestModel.setPhone(phone);
        UpdateCompanyRequestModel.setPhoneDeliver(phoneDeliver);
        UpdateCompanyRequestModel.setExpedPlace(expedPlace);
        UpdateCompanyRequestModel.setPersonalPhone1(personalPhone1);
        UpdateCompanyRequestModel.setPersonalPhone2(personalPhone2);
        UpdateCompanyRequestModel.setStreet(street);
        UpdateCompanyRequestModel.setCelen(celen);
        UpdateCompanyRequestModel.setCertificatePassword(certificatePassword);
        UpdateCompanyRequestModel.setStreetDeliver(streetDeliver);
        UpdateCompanyRequestModel.setColony(colony);
        UpdateCompanyRequestModel.setColonyDeliver(colonyDeliver);
        UpdateCompanyRequestModel.setLadaDeliver(ladaDeliver);
        UpdateCompanyRequestModel.setCp(Integer.valueOf(cp));
        UpdateCompanyRequestModel.setCpDeliver(Integer.valueOf(cpDeliver.isEmpty()?"0":cpDeliver));
        UpdateCompanyRequestModel.setCity(city);
        UpdateCompanyRequestModel.setCityDeliver(cityDeliver);
        UpdateCompanyRequestModel.setEstate(estate);
        UpdateCompanyRequestModel.setContactDeliver1(contactDeliver1);
        UpdateCompanyRequestModel.setContactDeliver2(contactDeliver2);
        UpdateCompanyRequestModel.setContactDeliver3(contactDeliver3);
        UpdateCompanyRequestModel.setEstateDeliver(estateDeliver);
        UpdateCompanyRequestModel.setCountry(country);
        UpdateCompanyRequestModel.setCountryDeliver(countryDeliver);
        UpdateCompanyRequestModel.setColonyDeliver(colonyDeliver);
        UpdateCompanyRequestModel.setColonyDeliver(colonyDeliver);
        UpdateCompanyRequestModel.setRfc(rfc);
        UpdateCompanyRequestModel.setEmail(email);
        UpdateCompanyRequestModel.setWebsite(website);
        UpdateCompanyRequestModel.setInteriorNumber(interiorNumber);
        UpdateCompanyRequestModel.setInteriorNumberDeliver(interiorNumberDeliver);
        UpdateCompanyRequestModel.setExternalNumber(externalNumber);
        UpdateCompanyRequestModel.setPathCert(pathCert);
        UpdateCompanyRequestModel.setExternalNumberDeliver(externalNumberDeliver);
        UpdateCompanyRequestModel.setPathCertKey(pathCertKey);
        UpdateCompanyRequestModel.setMoralOrPhisic(moralOrPhisic);
        UpdateCompanyRequestModel.setEstation(estation);
        UpdateCompanyRequestModel.setAppPath(appPath);
        UpdateCompanyRequestModel.setSucursal(sucursal);
        UpdateCompanyRequestModel.setCashNumber(cashNumber);        
        UpdateCompanyRequestModel.setCompanyDB(companyDB);
        UpdateCompanyRequestModel.setCostMethod(costMethod);
        UpdateCompanyRequestModel.setExtension(extension);
        UpdateCompanyRequestModel.setFiscalRegimen(fiscalRegimen);
        UpdateCompanyRequestModel.setTemplate(template);
                
        //Asign the request model to the manage
        this.BaseHttpClientManager.setBaseRequestModel(UpdateCompanyRequestModel);                
        
        //Subscribe to success event
        this.BaseHttpClientManager.setHttpClientSuccessSubscriberInterface((CloseableHttpResponse CloseableHttpResponse,String result) ->{
            
            //If subscribers
            if(UpdateCompanyHttpInterface!=null){
                
                //At this point the response is ok
                final HttpEntity entity = CloseableHttpResponse.getEntity();
                if(entity!=null){

                    //Get the response object                    
                    ObjectMapper mapper = new ObjectMapper();
                    final UpdateCompanyResponseRequestModel UpdateCompanyResponseRequestModel = mapper.readValue(result, UpdateCompanyResponseRequestModel.class);
                    
                    //If company updated
                    if("ok".equals(UpdateCompanyResponseRequestModel.getResponseStatus())){
                        UpdateCompanyHttpInterface.OnCompanyUpdated();
                    }
                    else{
                        if(ErrorCodeSubscriberInterface!=null){
                            ErrorCodeSubscriberInterface.onError(UpdateCompanyResponseRequestModel.getErrorCode());
                        }
                    }
                }
            }                            
        });
        
        //Execute the request
        this.BaseHttpClientManager.executePost();
    }
}