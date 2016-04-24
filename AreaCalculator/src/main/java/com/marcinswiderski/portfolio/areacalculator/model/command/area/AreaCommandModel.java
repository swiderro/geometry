package com.marcinswiderski.portfolio.areacalculator.model.command.area;

import com.marcinswiderski.portfolio.areacalculator.model.command.ArgumentParserFactory;
import com.marcinswiderski.portfolio.areacalculator.model.command.Command;
import com.marcinswiderski.portfolio.areacalculator.model.command.CommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.figure.Figure;
import com.marcinswiderski.portfolio.areacalculator.model.figure.FigureAreaExecutor;
import com.marcinswiderski.portfolio.areacalculator.model.figure.FigureAreaExecutorFactory;
import com.marcinswiderski.portfolio.areacalculator.model.result.CommandResult;
import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

import java.util.List;

public class AreaCommandModel implements CommandModel {

    private final List<CommandResult> commandCache;

    public AreaCommandModel(List<CommandResult> commandCache) {
        this.commandCache = commandCache;
    }

    @Override
    public Result execute(List<String> commandArguments) {
        Result result = null;
        ArgumentsParser argumentsParser = ArgumentParserFactory.getParser(Command.area);
        if (argumentsParser.parse(commandArguments).isValid()) {
            List arguments = argumentsParser.getArguments();
            FigureAreaExecutor figureAreaExecutor =
                    FigureAreaExecutorFactory.getExecutor((Figure) arguments.get(0));
            result = figureAreaExecutor.execute(arguments);
            CommandResult commandResult = new CommandResult(commandArguments, result.getStringValue());
            if (!commandCache.contains(commandResult)) {
                commandCache.add(commandResult);
            }
        }
        return result;
    }
}
