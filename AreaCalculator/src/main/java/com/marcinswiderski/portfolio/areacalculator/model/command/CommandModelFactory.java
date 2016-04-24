package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.model.command.area.AreaCommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.command.hello.HelloCommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.command.showall.ShowAllCommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.result.CommandResult;

import java.util.List;

public class CommandModelFactory {
    public static CommandModel getCommandModel(Command command, List<CommandResult> commandCache) {
        switch (command) {
            case hello:
                return new HelloCommandModel(commandCache);
            case area:
                return new AreaCommandModel(commandCache);
            case showall:
                return new ShowAllCommandModel(commandCache);
        }
        throw new IllegalArgumentException("No model implemented for command: " + command.name());
    }
}
