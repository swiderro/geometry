package com.marcinswiderski.portfolio.areacalculator.model.figure;

public class FigureAreaExecutorFactory {
    public static FigureAreaExecutor getExecutor(Figure figure) {
        switch (figure) {
            case circle:
                return new CircleAreaExecutor();
            case square:
                return new SquareAreaExecutor();
            case rectangle:
                return new RectangleAreaExecutor();
        }
        throw new IllegalArgumentException("No figure area executor implemented for figure: " + figure.name());
    }
}
