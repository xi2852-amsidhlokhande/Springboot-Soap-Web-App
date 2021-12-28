package com.amsidh.mvc.endpoint;

import com.amsidh.mvc.domain.GetCountryRequest;
import com.amsidh.mvc.domain.GetCountryResponse;
import com.amsidh.mvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.com/amsidh/mvc/domain";

    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryService.findCountry(request.getName()));

        return response;
    }
}
