package com.marcinswiderski.portfolio.bootstrap.commandLine;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Worker worker = new Worker(scanner, System.out);
        if (worker.isWorking()) {
            worker.giveInitialMessage();
        }
        while (worker.isWorking()) {
            worker.givePrompt().takeCommand();
        }
        scanner.close();
    }

}
