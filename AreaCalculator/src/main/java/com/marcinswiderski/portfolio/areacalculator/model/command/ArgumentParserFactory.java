package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.model.command.area.AreaArgumentsParser;
import com.marcinswiderski.portfolio.areacalculator.model.command.area.ArgumentsParser;
import com.marcinswiderski.portfolio.areacalculator.model.command.showall.ShowAllArgumentsParser;

public class ArgumentParserFactory {
    public static ArgumentsParser getParser(Command command) {
        switch (command) {
            case area:
                return new AreaArgumentsParser();
            case showall:
                return new ShowAllArgumentsParser();
        }
        throw new IllegalArgumentException("No argument parser implemented for command: " + command.name());
    }
}
