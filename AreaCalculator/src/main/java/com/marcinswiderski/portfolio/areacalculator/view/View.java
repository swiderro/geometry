package com.marcinswiderski.portfolio.areacalculator.view;

import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

public interface View {
    String getFormattedResult(Result result);

    public enum Types {
        STRING_ONE_LINE
    }
}
