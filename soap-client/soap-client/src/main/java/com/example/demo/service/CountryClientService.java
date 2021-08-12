package com.example.demo.service;

import com.example.demo.wsdl.countries.GetCountryRequest;
import com.example.demo.wsdl.countries.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClientService extends WebServiceGatewaySupport {

   private static final Logger log = LoggerFactory.getLogger(CountryClientService.class);

   public GetCountryResponse getCountry(String country) {

       GetCountryRequest request = new GetCountryRequest();
       request.setName(country);

       log.info("Requesting location for " + country);

       GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
               .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                       new SoapActionCallback(""));

       return response;
   }

}
