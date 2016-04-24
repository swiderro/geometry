package com.marcinswiderski.portfolio.areacalculator.controller;

import com.marcinswiderski.portfolio.areacalculator.model.*;
import com.marcinswiderski.portfolio.areacalculator.view.View;

import java.io.PrintStream;
import java.util.Scanner;

public class ScannerPrintStreamController {
    private static final Command FINISH_METHOD = Command.exit;
    private final PrintStream output;
    private final Scanner scanner;
    private boolean working;
    private String prompt;
    //TODO move to properties and use @Value
    private static String initialMessage;
    private CommandParser commandParser;

    static {
        initialMessage = "Welcome to Area Calculator. Please enter a command.";
    }

    public ScannerPrintStreamController(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.output = out;
        working = true;
        prompt = "\ncalculator > ";
        commandParser = new CommandParser();
    }

    public boolean isWorking() {
        return working;
    }

    public ScannerPrintStreamController givePrompt() {
        output.println(prompt);
        return this;
    }

    public ScannerPrintStreamController takeAndExecuteCommand() {
        String commandString = scanner.nextLine();
        try {
            Command command = commandParser.parse(commandString).getCommand();
            if (command != FINISH_METHOD) {
                CommandModel commandModel = CommandModelFactory.getCommandModel(command);
                Result result = commandModel.execute(commandParser.getCommandArguments());
                View view = commandModel.getView();
                output.println(view.getFormattedResult(result));
            } else {
                this.working = false;
            }
        } catch (RuntimeException runtimeException) {
            output.println(runtimeException.getMessage());
        }

        return this;
    }

    public ScannerPrintStreamController giveInitialMessage() {
        output.println(initialMessage);
        return this;
    }

    public String getPrompt() {
        return prompt;
    }

    public static String getInitialMessage() {
        return initialMessage;
    }
}
