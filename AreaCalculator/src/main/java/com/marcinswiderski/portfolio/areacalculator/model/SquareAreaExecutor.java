package com.marcinswiderski.portfolio.areacalculator.model;

import java.util.List;

public class SquareAreaExecutor implements FigureAreaExecutor {
    @Override
    public Result execute(List arguments) {
        Double a = (Double) arguments.get(0);
        return () -> Double.toString(a * a);
    }
}
