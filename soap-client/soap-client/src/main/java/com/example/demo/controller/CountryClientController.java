package com.example.demo.controller;

import com.example.demo.wsdl.countries.GetCountryResponse;
import com.example.demo.service.CountryClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryClientController {

   @Autowired
   private CountryClientService clientService;
   /*@GetMapping("/getCountry")
   public GetCountryResponse getCountryResponse() {

       String country = "Mexico";

       return clientService.getCountry(country);*/
   
   @GetMapping("/")
   public String hola() {
	   return "¡Bienvenido a soap-client!";
   }
   
   @GetMapping("/countries")
   public GetCountryResponse getCountryResponse(@RequestParam String country) {
	   return clientService.getCountry(country);
   }
   
   
   @PostMapping("/countries")
   public GetCountryResponse postCountryResponse(@RequestBody String country) {
       return clientService.getCountry(country);
   }

   
}