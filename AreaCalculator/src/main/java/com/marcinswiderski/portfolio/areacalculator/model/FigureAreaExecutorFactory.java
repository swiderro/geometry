package com.marcinswiderski.portfolio.areacalculator.model;

public class FigureAreaExecutorFactory {
    public static FigureAreaExecutor getExecutor(Figure figure) {
        switch (figure) {
            case circle:
                return new CircleAreaExecutor();
        }
        throw new IllegalArgumentException("No figure area executor implemented for command: " + figure.name());
    }
}
