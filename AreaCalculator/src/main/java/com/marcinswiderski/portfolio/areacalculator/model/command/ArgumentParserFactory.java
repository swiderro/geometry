package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.model.command.area.AreaArgumentsParser;
import com.marcinswiderski.portfolio.areacalculator.model.command.area.ArgumentsParser;

public class ArgumentParserFactory {
    public static ArgumentsParser getParser(Command command) {
        switch (command) {
            case area:
                return new AreaArgumentsParser();
        }
        throw new IllegalArgumentException("No argument parser implemented for command: " + command.name());
    }
}
