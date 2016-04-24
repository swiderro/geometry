package com.marcinswiderski.portfolio.areacalculator.exception;

import com.marcinswiderski.portfolio.areacalculator.model.Figure;

public class IllegalArgumentNumberForFigureAreaException extends RuntimeException {
    public IllegalArgumentNumberForFigureAreaException(Figure figure) {
        super("Figure " + figure.name() + " takes " +
                figure.getNumOfArgumentsReqForAreaCalculation() + " to calculate area.");
    }
}
