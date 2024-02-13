package com.demo.timeseries.dto.response;

import com.demo.timeseries.dto.Meta;
import com.demo.timeseries.dto.TimeSeriesData;

import java.io.Serializable;
import java.util.List;


public class TimeSeriesResponse implements Serializable {

    private Meta meta;
    private List<TimeSeriesData> values;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<TimeSeriesData> getValues() {
        return values;
    }

    public void setValues(List<TimeSeriesData> values) {
        this.values = values;
    }
}