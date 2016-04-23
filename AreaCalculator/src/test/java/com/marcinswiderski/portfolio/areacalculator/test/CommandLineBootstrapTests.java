package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.bootstrap.commandline.Worker;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CommandLineBootstrapTests {

    @Test
    public void WorkerWorkingOnCreationTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        Worker worker = new Worker(mockedScanner, mockedOutput);
        assertTrue(worker.isWorking());
    }

    @Test
    public void WorkerPromptTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        Worker worker = new Worker(mockedScanner, mockedOutput);
        worker.givePrompt();
        verify(mockedOutput).print(worker.getPrompt());
    }

    @Test
    public void WorkerTakeCommandTest() throws IOException {
        PrintStream mockedOutput = mock(PrintStream.class);
        String command = "foo bar\n";
        byte[] commandBytes = command.getBytes();
        InputStream inputStream = new ByteArrayInputStream(commandBytes);
        InputStream spy = spy(inputStream);
        Scanner mockedScanner = new Scanner(spy);
        Worker worker = new Worker(mockedScanner, mockedOutput);
        worker.takeCommand();
        //BARK!!!
        int twoToThirteenth = 8192;
        byte[] bytesRead = Arrays.copyOf(commandBytes, twoToThirteenth);
        verify(spy).read(
                bytesRead,
                0,
                twoToThirteenth
        );
    }

    @Test
    public void WorkerInitialMessageTest() {
        PrintStream mockedOutput = mock(PrintStream.class);
        Scanner mockedScanner = new Scanner(mock(InputStream.class));
        Worker worker = new Worker(mockedScanner, mockedOutput);
        worker.giveInitialMessage();
        verify(mockedOutput).println(worker.getInitialMessage());
    }

}
