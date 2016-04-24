package com.marcinswiderski.portfolio.areacalculator.model.command.hello;

import com.marcinswiderski.portfolio.areacalculator.model.command.CommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.result.CommandResult;
import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

import java.util.List;

public class HelloCommandModel implements CommandModel {

    //TODO move to properties and use @Value
    private static final String outputMessage = "Welcome to Area Calculator. Please enter a command.";

    public HelloCommandModel(List<CommandResult> commandCache) {

    }

    public static String getOutputMessage() {
        return outputMessage;
    }

    @Override
    public Result execute(List<String> commandArguments) {
        return () -> outputMessage;
    }
}
