package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.model.command.CommandParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandParserTests {

    @Test(expected = IllegalArgumentException.class)
    public void parseUnknownCommandTest() {
        CommandParser commandParser = new CommandParser();
        assertTrue(commandParser.parse("unknown").isValid());
    }

    @Test
    public void parseHelloExitShowAllPositiveCommandTest() {
        CommandParser commandParser = new CommandParser();
        assertTrue(commandParser.parse("hello").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 1);
        assertTrue(commandParser.parse("exit").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 1);
        assertTrue(commandParser.parse("showall").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 1);
        assertTrue(commandParser.parse("showall dotted").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 2);
        assertTrue(commandParser.parse("area circle 1").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 3);
        assertTrue(commandParser.parse("area square 1").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 3);
        assertTrue(commandParser.parse("area rectangle 1 3").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 4);
    }

}
