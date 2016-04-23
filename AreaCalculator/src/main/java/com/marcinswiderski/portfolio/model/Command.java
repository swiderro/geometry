package com.marcinswiderski.portfolio.model;

public enum Command {
    AREA("area"),
    HELLO("hello"),
    SHOWALL("showall"),
    EXIT("exit");

    private final String commandString;

    Command(String commandString) {
        this.commandString = commandString;
    }
}
