package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.controller.ScannerPrintStreamController;
import com.marcinswiderski.portfolio.areacalculator.model.command.hello.HelloCommandModel;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.marcinswiderski.portfolio.areacalculator.model.command.Command.*;
import static com.marcinswiderski.portfolio.areacalculator.model.figure.Figure.*;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class CommandExecutionTests {

    @Test
    public void ControllerTakeAndExecuteHelloCommandTest() throws IOException {
        PrintStream mockedOutput = mock(PrintStream.class);
        String command = hello.name() + "\n";
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
        String command = exit.name() + "\n";
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

    @Test
    public void ControllerTakeAndExecuteAreaCommandTest() throws IOException {
        PrintStream mockedOutput = mock(PrintStream.class);
        String[] commands = new String[]{
                hello.name() + "\n",
                area.name() + " " + rectangle.name() + " 2 3\n",
                area.name() + " " + square.name() + " 2\n",
                area.name() + " " + circle.name() + " 1\n",
                exit.name() + "\n"
        };
        byte[] commandBytes = (Arrays.asList(commands).stream().collect(Collectors.joining())).getBytes();
        InputStream inputStream = new ByteArrayInputStream(commandBytes);
        InputStream inputStreamSpy = spy(inputStream);
        Scanner mockedScanner = new Scanner(inputStreamSpy);
        ScannerPrintStreamController scannerPrintStreamController =
                new ScannerPrintStreamController(mockedScanner, mockedOutput);
        for (String command : commands) {
            scannerPrintStreamController.takeAndExecuteCommand();
        }
        //BARK!!!
        int twoToThirteenth = 8192;
        byte[] bytesRead = Arrays.copyOf(commandBytes, twoToThirteenth);
        verify(inputStreamSpy).read(
                bytesRead,
                0,
                twoToThirteenth
        );
        verify(mockedOutput).println(HelloCommandModel.getOutputMessage());
        verify(mockedOutput).println(Double.toString(2 * 3));
        verify(mockedOutput).println(Double.toString(2 * 2));
        verify(mockedOutput).println(Double.toString(1 * 1 * Math.PI));
        assertFalse(scannerPrintStreamController.isWorking());
    }

}
