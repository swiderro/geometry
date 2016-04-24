package com.marcinswiderski.portfolio.areacalculator.model.figure;

import com.marcinswiderski.portfolio.areacalculator.model.result.Result;
import com.marcinswiderski.portfolio.areacalculator.model.result.StringResult;

import java.util.List;

public class SquareAreaExecutor implements FigureAreaExecutor {
    @Override
    public Result execute(List arguments) {
        Double a = (Double) arguments.get(1);
        return new StringResult(Double.toString(a * a));
    }
}
