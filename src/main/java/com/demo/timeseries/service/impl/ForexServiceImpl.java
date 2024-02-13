package com.demo.timeseries.service.impl;

import com.demo.timeseries.dto.request.TimeSeriesRequest;
import com.demo.timeseries.dto.response.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service("forexService")
public class ForexServiceImpl implements com.demo.timeseries.service.ForexService {

    private static final String BASEURL = "https://api.twelvedata.com/time_series";
    private final RestTemplate restTemplate;
    String apiKey = "09b1e2bbf03c4e2f83c51402b58b7910"; // get it from properties file

    @Autowired
    public ForexServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TimeSeriesResponse getForexData(TimeSeriesRequest timeSeriesRequest) {
        //exchange or getForEntity does not matter , under the hood execute is wroking
        //execute is designed to be applicable in the highest variety of scenarios possible
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        final String apiUrl = BASEURL
                + "?"
                + "apikey=" + apiKey
                + timeSeriesRequest.toRequestString();

        ResponseEntity<TimeSeriesResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                TimeSeriesResponse.class
        );

        return response.getBody();
    }

}
