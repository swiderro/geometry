package com.marcinswiderski.portfolio.areacalculator.model.result;

public class StringResult implements Result {
    private String value;

    public StringResult(String value) {
        this.value = value;
    }

    @Override
    public String getStringValue() {
        return value;
    }
}
