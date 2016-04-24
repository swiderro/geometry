package com.marcinswiderski.portfolio.areacalculator.model.command.showall;

import com.marcinswiderski.portfolio.areacalculator.model.command.ArgumentParserFactory;
import com.marcinswiderski.portfolio.areacalculator.model.command.Command;
import com.marcinswiderski.portfolio.areacalculator.model.command.CommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.command.area.ArgumentsParser;
import com.marcinswiderski.portfolio.areacalculator.model.result.CommandResult;
import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

import java.util.List;

public class ShowAllCommandModel implements CommandModel {
    private ShowAllExecutor showAllExecutor;

    public ShowAllCommandModel(List<CommandResult> commandCache) {
        showAllExecutor = new ShowAllExecutor(commandCache);
    }

    @Override
    public Result execute(List<String> commandArguments) {
        Result result = null;
        ArgumentsParser argumentsParser = ArgumentParserFactory.getParser(Command.showall);
        if (argumentsParser.parse(commandArguments).isValid()) {
            List arguments = argumentsParser.getArguments();
            result = showAllExecutor.execute(arguments);
        }
        return result;
    }
}
