package com.example.demo.config;

import com.example.demo.service.CountryClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryClientConfig {

   @Bean
   public Jaxb2Marshaller marshaller() {
       Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
       // this package must match the package in the <generatePackage> specified in
       // pom.xml
       marshaller.setContextPath("com.example.demo.wsdl.countries");
       return marshaller;
   }

   @Bean
   public CountryClientService countryClient(Jaxb2Marshaller marshaller) {
       CountryClientService client = new CountryClientService();
       client.setDefaultUri("http://localhost:8080/ws");
       client.setMarshaller(marshaller);
       client.setUnmarshaller(marshaller);
       return client;
   }

}
