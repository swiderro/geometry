package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.controller.ScannerPrintStreamController;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommandLineBootstrapTests {

    @Test
    public void ControllerWorkingOnCreationTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        ScannerPrintStreamController scannerPrintStreamController = new ScannerPrintStreamController(mockedScanner, mockedOutput);
        assertTrue(scannerPrintStreamController.isWorking());
    }

    @Test
    public void ControllerPromptTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        ScannerPrintStreamController scannerPrintStreamController = new ScannerPrintStreamController(mockedScanner, mockedOutput);
        scannerPrintStreamController.givePrompt();
        verify(mockedOutput).println(scannerPrintStreamController.getPrompt());
    }

    @Test
    public void ControllerInitialMessageTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        ScannerPrintStreamController scannerPrintStreamController = new ScannerPrintStreamController(mockedScanner, mockedOutput);
        scannerPrintStreamController.giveInitialMessage();
        verify(mockedOutput).println(scannerPrintStreamController.getInitialMessage());
    }

}
