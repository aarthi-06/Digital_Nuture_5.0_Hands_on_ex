package com.cognizant.rest_api_demo.controller;

import com.cognizant.rest_api_demo.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.cognizant.rest_api_demo.service.CountryService;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.rest_api_demo.exception.CountryNotFoundException;

@RestController
public class CountryController {

    private final ApplicationContext context;

    private final CountryService countryService;

    public CountryController(ApplicationContext context,
                             CountryService countryService) {

        this.context = context;
        this.countryService = countryService;
    }


    @RequestMapping("/country")
    public Country getCountryIndia() {

        return context.getBean("country", Country.class);

    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }


}