package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.exception.IllegalArgumentNumberForFigureAreaException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommandParser {

    private String separator;

    private boolean valid;
    private List<String> commandArguments;
    private Command command;

    public CommandParser() {
        this.valid = false;
        this.commandArguments = null;
        this.separator = " ";
        this.command = null;
    }

    public CommandParser parse(String inputLine) throws IllegalArgumentNumberForFigureAreaException {
        List<String> inputLineExploded = new LinkedList<String>(Arrays.asList(inputLine.split(separator)));
        extractCommand(inputLineExploded);
        commandArguments = inputLineExploded;
        valid = true;
        return this;
    }

    private void extractCommand(List<String> commandLineArguments) {
        this.command = Command.valueOf(commandLineArguments.get(0));
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getCommandArguments() {
        return commandArguments;
    }

    public Command getCommand() {
        return command;
    }
}
