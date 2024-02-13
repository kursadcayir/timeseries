package com.demo.timeseries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

    private final String symbol;
    private final String interval;

    @JsonProperty("currency_base")
    private final String currencyBase;
    @JsonProperty("currency_quote")
    private final String currencyQuote;
    private final String type;

    public Meta(String symbol, String interval, String currencyBase, String currencyQuote, String type) {
        this.symbol = symbol;
        this.interval = interval;
        this.currencyBase = currencyBase;
        this.currencyQuote = currencyQuote;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getInterval() {
        return interval;
    }

    public String getCurrencyBase() {
        return currencyBase;
    }

    public String getCurrencyQuote() {
        return currencyQuote;
    }

    public String getType() {
        return type;
    }
}
