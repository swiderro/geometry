package com.marcinswiderski.portfolio.areacalculator.model;

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
