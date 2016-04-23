package com.marcinswiderski.portfolio.areacalculator.model;

public enum Command {
    area(2, 3),
    exit(0, 0),
    hello(0, 0),
    showall(0, 1);
    private int maxArgumentsNumber;
    private int minArgumentsNumber;

    Command(int minArgumentsNumber, int maxArgumentsNumber) {
        this.minArgumentsNumber = minArgumentsNumber;
        this.maxArgumentsNumber = maxArgumentsNumber;
    }

    public int getMaxArgumentsNumber() {
        return maxArgumentsNumber;
    }
}
