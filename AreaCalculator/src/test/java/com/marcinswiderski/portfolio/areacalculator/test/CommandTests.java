package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.model.Command;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CommandTests {

    @Test
    public void parseExitCommandTest() {
        String commandString = "exit";
        Command command = Command.valueOf(commandString);
        assertNotNull(command);
        assertTrue(command.name().equalsIgnoreCase(commandString));
    }

    @Test
    public void parseHelloCommandTest() {
        String commandString = "hello";
        Command command = Command.valueOf(commandString);
        assertNotNull(command);
        assertTrue(command.name().equalsIgnoreCase(commandString));
    }

    @Test
    public void parseAreaCommandTest() {
        String commandString = "area";
        Command command = Command.valueOf(commandString);
        assertNotNull(command);
        assertTrue(command.name().equalsIgnoreCase(commandString));
    }

    @Test
    public void parseShowAllCommandTest() {
        String commandString = "showAll";
        Command command = Command.valueOf(commandString);
        assertNotNull(command);
        assertTrue(command.name().equalsIgnoreCase(commandString));
    }

}
