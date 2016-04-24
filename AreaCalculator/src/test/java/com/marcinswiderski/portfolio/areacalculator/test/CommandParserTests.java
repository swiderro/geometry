package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.model.CommandParser;
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
        assertTrue(commandParser.getCommandArguments().isEmpty());
        assertTrue(commandParser.parse("exit").isValid());
        assertTrue(commandParser.getCommandArguments().isEmpty());
        assertTrue(commandParser.parse("showall").isValid());
        assertTrue(commandParser.getCommandArguments().isEmpty());
        assertTrue(commandParser.parse("showall dotted").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 1);
        assertTrue(commandParser.parse("area circle 1").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 2);
        assertTrue(commandParser.parse("area square 1").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 2);
        assertTrue(commandParser.parse("area rectangle 1 3").isValid());
        assertTrue(commandParser.getCommandArguments().size() == 3);
    }

//    @Test(expected = IllegalArgumentNumberForCommandException.class)
//    public void parseHelloInvalidArgumentsNumberTest() {
//        CommandParser commandParser = new CommandParser();
//        assertTrue(!commandParser.parse("hello world").isValid());
//    }
//
//    @Test(expected = IllegalArgumentNumberForCommandException.class)
//    public void parseExitInvalidArgumentsNumberTest() {
//        CommandParser commandParser = new CommandParser();
//        assertTrue(!commandParser.parse("exit world").isValid());
//    }
//
//    @Test(expected = IllegalArgumentNumberForCommandException.class)
//    public void parseShowAllInvalidArgumentsNumberTest() {
//        CommandParser commandParser = new CommandParser();
//        assertTrue(!commandParser.parse("showall spotted dotted").isValid());
//    }
}
