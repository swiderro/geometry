package com.marcinswiderski.portfolio.areacalculator.bootstrap.commandline;

import com.marcinswiderski.portfolio.areacalculator.model.InputParser;

import java.io.PrintStream;
import java.util.Scanner;

public class Worker {
    private final PrintStream output;
    private final Scanner scanner;
    private boolean working;
    private String prompt;
    private String initialMessage;
    private InputParser inputParser;

    public Worker(Scanner scanner, PrintStream out) {
        this.scanner = scanner;
        this.output = out;
        working = true;
        prompt = "calculator > ";
        initialMessage = "Welcome to Area Calculator. Please enter a command.";
        inputParser = new InputParser();
    }

    public boolean isWorking() {
        return working;
    }

    public Worker givePrompt() {
        output.print(prompt);
        return this;
    }

    public Worker takeCommand() {
        String commandString = scanner.nextLine();
        try {
            inputParser.parse(commandString);
        } catch (RuntimeException runtimeException) {
            output.println(runtimeException.getMessage());
        }

        return this;
    }

    public Worker giveInitialMessage() {
        output.println(initialMessage);
        return this;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getInitialMessage() {
        return initialMessage;
    }
}
