package com.marcinswiderski.portfolio.areacalculator.bootstrap.commandline;

import com.marcinswiderski.portfolio.areacalculator.controller.ScannerPrintStreamController;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScannerPrintStreamController scannerPrintStreamController =
                new ScannerPrintStreamController(
                        scanner, System.out
                );
        if (scannerPrintStreamController.isWorking()) {
            scannerPrintStreamController.giveInitialMessage();
        }
        while (scannerPrintStreamController.isWorking()) {
            scannerPrintStreamController.givePrompt().takeAndExecuteCommand();
        }
        scanner.close();
    }

}
