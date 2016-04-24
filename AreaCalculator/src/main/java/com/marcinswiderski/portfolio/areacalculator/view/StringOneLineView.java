package com.marcinswiderski.portfolio.areacalculator.view;

import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

public class StringOneLineView implements View {
    @Override
    public String getFormattedResult(Result result) {
        return result.getStringValue();
//        String unFormattedResult = result.getStringValue();
//        //TODO Regex it
//        String formattedResult = unFormattedResult.replace('\n',' ').replace("\r\n","");
//        return formattedResult;
    }
}
