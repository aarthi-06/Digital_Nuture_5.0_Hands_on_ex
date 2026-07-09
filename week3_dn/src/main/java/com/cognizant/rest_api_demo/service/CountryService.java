package com.cognizant.rest_api_demo.service;

import com.cognizant.rest_api_demo.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.cognizant.rest_api_demo.exception.CountryNotFoundException;
import java.util.List;

@Service
public class CountryService {

    private final ApplicationContext context;

    public CountryService(ApplicationContext context) {
        this.context = context;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        List<Country> countries = (List<Country>) context.getBean("countryList");

        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }
}