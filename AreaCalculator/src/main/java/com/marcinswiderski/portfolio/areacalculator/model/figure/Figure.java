package com.marcinswiderski.portfolio.areacalculator.model.figure;

public enum Figure {
    circle(1),
    square(1),
    rectangle(2);
    private int numOfArgumentsReqForAreaCalculation;

    Figure(int numOfArgumentsReqForAreaCalculation) {
        this.numOfArgumentsReqForAreaCalculation = numOfArgumentsReqForAreaCalculation;
    }

    public int getNumOfArgumentsReqForAreaCalculation() {
        return numOfArgumentsReqForAreaCalculation;
    }
}
