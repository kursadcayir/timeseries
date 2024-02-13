package com.demo.timeseries.dto.request;

import org.springframework.util.ObjectUtils;

public class TimeSeriesRequest {
    private final String startDate;
    private final String endDate;
    private final String interval;
    private final String symbol;
    private final String country;
    private final String outputsize;
    private final String format;

    public TimeSeriesRequest(String startDate, String endDate, String interval, String symbol, String country, String outputsize, String format) {
        this.startDate = ObjectUtils.isEmpty(startDate) ?  "2021-01-01" : startDate;
        this.endDate = ObjectUtils.isEmpty(endDate) ?  "2021-01-01" : endDate;
        this.interval = ObjectUtils.isEmpty(interval) ?  "2h" : interval;
        this.symbol = ObjectUtils.isEmpty(symbol) ?  "EUR/USD" : symbol;
        this.country = ObjectUtils.isEmpty(country) ?  "US" : country;
        this.outputsize =  ObjectUtils.isEmpty(outputsize) ?  "6" : outputsize;
        this.format = ObjectUtils.isEmpty(format) ?  "JSON" : outputsize;
    }

    public TimeSeriesRequest(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.interval = "2h";
        this.symbol = "EUR/USD";
        this.country = "US" ;
        this.outputsize =  "6";
        this.format = "JSON";
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInterval() {
        return interval;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCountry() {
        return country;
    }

    public String getOutputsize() {
        return outputsize;
    }

    public String getFormat() {
        return format;
    }

    public String toString() {
        return "TimeSeriesRequest{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", interval='" + interval + '\'' +
                ", symbol='" + symbol + '\'' +
                ", country='" + country + '\'' +
                ", outputsize='" + outputsize + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
    public String toRequestString(){
        return "&end_date="+endDate +"&start_date="+startDate +"&interval=" + interval + "&symbol=" + symbol + "&country=" + country + "&outputsize=" + outputsize + "&format=" + format;
    }
}
