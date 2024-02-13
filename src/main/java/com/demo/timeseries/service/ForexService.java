package com.demo.timeseries.service;

import com.demo.timeseries.dto.request.TimeSeriesRequest;
import com.demo.timeseries.dto.response.TimeSeriesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

public interface ForexService {

    TimeSeriesResponse getForexData(TimeSeriesRequest timeSeriesRequest) throws RestClientException;
}
