package com.demo.timeseries.controller;

import com.demo.timeseries.dto.request.TimeSeriesRequest;
import com.demo.timeseries.dto.response.TimeSeriesResponse;
import com.demo.timeseries.service.ForexService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/timeseries")
public class TimeSeriesController {


    private final ForexService forexService;


    public TimeSeriesController(ForexService forexService) {
        this.forexService = forexService;
    }

    @GetMapping
    public ResponseEntity<TimeSeriesResponse> getTimeseries(
            @RequestParam("start_date") String startDate,
            @RequestParam("end_date") String endDate
    ) {
        TimeSeriesRequest timeSeriesRequest = new TimeSeriesRequest(startDate, endDate);
        try {
            TimeSeriesResponse response = forexService.getForexData(timeSeriesRequest);
            return ResponseEntity.status(200).body(response);
        } catch (Exception e) {
            System.out.println("Error in getTimeseries: " + e.getMessage());
            return ResponseEntity.status(500).body(new TimeSeriesResponse());
        }
    }

}

