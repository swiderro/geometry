package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.model.command.area.AreaCommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.command.hello.HelloCommandModel;

public class CommandModelFactory {
    public static CommandModel getCommandModel(Command command) {
        switch (command) {
            case hello:
                return new HelloCommandModel();
            case area:
                return new AreaCommandModel();
        }
        throw new IllegalArgumentException("No model implemented for command: " + command.name());
    }
}
