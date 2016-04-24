package com.marcinswiderski.portfolio.areacalculator.model;

public class ArgumentParserFactory {
    public static ArgumentsParser getParser(Command command) {
        switch (command) {
            case area:
                return new AreaArgumentsParser();
        }
        throw new IllegalArgumentException("No argument parser implemented for command: " + command.name());
    }
}
