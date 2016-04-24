package com.marcinswiderski.portfolio.areacalculator.model;

import com.marcinswiderski.portfolio.areacalculator.exception.IllegalArgumentNumberForCommandException;

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

    public CommandParser parse(String inputLine) throws IllegalArgumentNumberForCommandException {
        List<String> inputLineExploded = new LinkedList<String>(Arrays.asList(inputLine.split(separator)));
        extractCommand(inputLineExploded);
//        validateArgumentsNumber(inputLineExploded);
        commandArguments = inputLineExploded;
        valid = true;
        return this;
    }

    private void extractCommand(List<String> commandLineArguments) {
        this.command = Command.valueOf(commandLineArguments.remove(0));
    }

//    private void validateArgumentsNumber(List<String> commandLineArguments) throws IllegalArgumentNumberForCommandException {
//        if (commandLineArguments.size() > command.getMaxArgumentsNumber()) {
//            IllegalArgumentNumberForCommandException exception = new IllegalArgumentNumberForCommandException(command);
//            invalidate();
//            throw exception;
//        }
//    }

    private void invalidate() {
        this.valid = false;
        this.command = null;
        this.commandArguments = null;
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
