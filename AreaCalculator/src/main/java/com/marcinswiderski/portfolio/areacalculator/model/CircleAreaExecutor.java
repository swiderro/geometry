package com.marcinswiderski.portfolio.areacalculator.model;

import java.util.List;

public class CircleAreaExecutor implements FigureAreaExecutor {
    @Override
    public Result execute(List arguments) {
        Double r = (Double) arguments.get(0);
        return () -> Double.toString(r * r * Math.PI);
    }
}
