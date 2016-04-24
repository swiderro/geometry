package com.marcinswiderski.portfolio.areacalculator.model;

import com.marcinswiderski.portfolio.areacalculator.exception.IllegalArgumentNumberForFigureAreaException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AreaArgumentsParser implements ArgumentsParser {
    private boolean valid = false;
    private List arguments = new LinkedList<Double>();

    @Override
    public ArgumentsParser parse(List<String> commandArguments) {
        //will throw exception on unknown figure
        Figure figure = Figure.valueOf(commandArguments.remove(0));
        arguments.add(figure);
        if (commandArguments.size() != figure.getNumOfArgumentsReqForAreaCalculation()) {
            throw new IllegalArgumentNumberForFigureAreaException(figure);
        }
        //will throw exception on incorrect number
        arguments.addAll(commandArguments.stream().map(Double::parseDouble).collect(Collectors.toList()));
        valid = true;
        return this;
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public List getArguments() {
        return arguments;
    }
}
