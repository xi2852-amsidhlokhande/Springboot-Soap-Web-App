package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.domain.Country;
import com.amsidh.mvc.domain.Currency;
import com.amsidh.mvc.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Map<String, Country> countries = new HashMap<>();

    static {
        Country india = new Country();
        india.setName("India");
        india.setCurrency(Currency.EUR);
        india.setCapital("Delhi");
        india.setPopulation(1000);
        countries.put("india", india);
    }

    @Override
    public Country findCountry(String name) {
        return countries.get(name);
    }
}
