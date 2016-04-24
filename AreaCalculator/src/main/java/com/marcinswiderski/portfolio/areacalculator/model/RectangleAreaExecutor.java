package com.marcinswiderski.portfolio.areacalculator.model;

import java.util.List;

public class RectangleAreaExecutor implements FigureAreaExecutor {
    @Override
    public Result execute(List arguments) {
        Double a = (Double) arguments.get(0);
        Double b = (Double) arguments.get(1);
        return () -> Double.toString(a * b);
    }
}
