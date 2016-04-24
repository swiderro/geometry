package com.marcinswiderski.portfolio.areacalculator.model.command.area;

import com.marcinswiderski.portfolio.areacalculator.exception.IllegalArgumentNumberForFigureAreaException;
import com.marcinswiderski.portfolio.areacalculator.model.figure.Figure;

import java.util.LinkedList;
import java.util.List;

public class AreaArgumentsParser implements ArgumentsParser {
    private boolean valid = false;
    private List arguments = new LinkedList<Double>();

    @Override
    public ArgumentsParser parse(List<String> commandArguments) {
        //will throw exception on unknown figure
        Figure figure = Figure.valueOf(commandArguments.get(1));
        arguments.add(figure);
        if (commandArguments.size() - 2 != figure.getNumOfArgumentsReqForAreaCalculation()) {
            throw new IllegalArgumentNumberForFigureAreaException(figure);
        }
        //will throw exception on incorrect number
        for (int i = 2; i < commandArguments.size(); i++) {
            arguments.add(Double.parseDouble(commandArguments.get(i)));
        }
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
