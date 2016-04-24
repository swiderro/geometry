package com.marcinswiderski.portfolio.areacalculator.model;

import com.marcinswiderski.portfolio.areacalculator.view.View;
import com.marcinswiderski.portfolio.areacalculator.view.ViewFactory;

import java.util.List;

public class HelloCommandModel implements CommandModel {

    //TODO move to properties and use @Value
    private static String outputMessage = "Welcome to Area Calculator. Please enter a command.";

    public static String getOutputMessage() {
        return outputMessage;
    }

    @Override
    public Result execute(List<String> commandArguments) {
        Result result = new Result() {
            @Override
            public String getStringValue() {
                return outputMessage;
            }
        };
        return result;
    }

    @Override
    public View getView() {
        return ViewFactory.getView(View.Types.STRING_ONE_LINE);
    }
}
