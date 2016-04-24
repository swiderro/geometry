package com.marcinswiderski.portfolio.areacalculator.model.command.area;

import com.marcinswiderski.portfolio.areacalculator.model.command.ArgumentParserFactory;
import com.marcinswiderski.portfolio.areacalculator.model.command.Command;
import com.marcinswiderski.portfolio.areacalculator.model.command.CommandModel;
import com.marcinswiderski.portfolio.areacalculator.model.figure.Figure;
import com.marcinswiderski.portfolio.areacalculator.model.figure.FigureAreaExecutor;
import com.marcinswiderski.portfolio.areacalculator.model.figure.FigureAreaExecutorFactory;
import com.marcinswiderski.portfolio.areacalculator.model.result.Result;

import java.util.List;

public class AreaCommandModel implements CommandModel {
    @Override
    public Result execute(List<String> commandArguments) {
        Result result = null;
        ArgumentsParser argumentsParser = ArgumentParserFactory.getParser(Command.area);
        if (argumentsParser.parse(commandArguments).isValid()) {
            List arguments = argumentsParser.getArguments();
            FigureAreaExecutor figureAreaExecutor =
                    FigureAreaExecutorFactory.getExecutor((Figure) arguments.remove(0));
            result = figureAreaExecutor.execute(arguments);
        }
        return result;
    }
}
