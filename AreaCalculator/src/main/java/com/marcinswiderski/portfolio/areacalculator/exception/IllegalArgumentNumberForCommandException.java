package com.marcinswiderski.portfolio.areacalculator.exception;

import com.marcinswiderski.portfolio.areacalculator.model.Command;

public class IllegalArgumentNumberForCommandException extends RuntimeException {
    public IllegalArgumentNumberForCommandException(Command command) {
        super("Command " + command.name() + " takes " + command.getMaxArgumentsNumber() + " arguments.");
    }
}