package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.controller.ScannerPrintStreamController;
import com.marcinswiderski.portfolio.areacalculator.model.Command;
import com.marcinswiderski.portfolio.areacalculator.model.HelloCommandModel;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CommandExecutionTests {

    @Test
    public void ControllerTakeAndExecuteHelloCommandTest() throws IOException {
        PrintStream mockedOutput = mock(PrintStream.class);
        String command = Command.hello.name() + "\n";
        byte[] commandBytes = command.getBytes();
        InputStream inputStream = new ByteArrayInputStream(commandBytes);
        InputStream inputStreamSpy = spy(inputStream);
        Scanner mockedScanner = new Scanner(inputStreamSpy);
        ScannerPrintStreamController scannerPrintStreamController =
                new ScannerPrintStreamController(mockedScanner, mockedOutput);
        scannerPrintStreamController.takeAndExecuteCommand();
        //BARK!!!
        int twoToThirteenth = 8192;
        byte[] bytesRead = Arrays.copyOf(commandBytes, twoToThirteenth);
        verify(inputStreamSpy).read(
                bytesRead,
                0,
                twoToThirteenth
        );
        verify(mockedOutput).println(HelloCommandModel.getOutputMessage());
    }

    @Test
    public void ControllerTakeAndExecuteExitCommandTest() throws IOException {
        PrintStream mockedOutput = mock(PrintStream.class);
        String command = Command.exit.name() + "\n";
        byte[] commandBytes = command.getBytes();
        InputStream inputStream = new ByteArrayInputStream(commandBytes);
        InputStream inputStreamSpy = spy(inputStream);
        Scanner mockedScanner = new Scanner(inputStreamSpy);
        ScannerPrintStreamController scannerPrintStreamController =
                new ScannerPrintStreamController(mockedScanner, mockedOutput);
        scannerPrintStreamController.takeAndExecuteCommand();
        //BARK!!!
        int twoToThirteenth = 8192;
        byte[] bytesRead = Arrays.copyOf(commandBytes, twoToThirteenth);
        verify(inputStreamSpy).read(
                bytesRead,
                0,
                twoToThirteenth
        );
        assertFalse(scannerPrintStreamController.isWorking());
    }

}
