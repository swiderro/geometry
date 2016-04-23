package com.marcinswiderski.portfolio.areacalculator.test;

import com.marcinswiderski.portfolio.areacalculator.exception.IllegalArgumentNumberForCommandException;
import com.marcinswiderski.portfolio.areacalculator.model.InputParser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InputParserTests {

    @Test(expected = IllegalArgumentException.class)
    public void parseUnknownCommandTest() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.parse("unknown").isValid());
    }

    @Test
    public void parseHelloExitShowAllPositiveCommandTest() {
        InputParser inputParser = new InputParser();
        assertTrue(inputParser.parse("hello").isValid());
        assertTrue(inputParser.getCommandArguments().isEmpty());
        assertTrue(inputParser.parse("exit").isValid());
        assertTrue(inputParser.getCommandArguments().isEmpty());
        assertTrue(inputParser.parse("showall").isValid());
        assertTrue(inputParser.getCommandArguments().isEmpty());
        assertTrue(inputParser.parse("showall dotted").isValid());
        assertTrue(inputParser.getCommandArguments().size() == 1);
        assertTrue(inputParser.parse("area circle 1").isValid());
        assertTrue(inputParser.getCommandArguments().size() == 2);
        assertTrue(inputParser.parse("area square 1").isValid());
        assertTrue(inputParser.getCommandArguments().size() == 2);
        assertTrue(inputParser.parse("area rectangle 1 3").isValid());
        assertTrue(inputParser.getCommandArguments().size() == 3);
    }

    @Test(expected = IllegalArgumentNumberForCommandException.class)
    public void parseHelloInvalidArgumentsNumberTest() {
        InputParser inputParser = new InputParser();
        assertTrue(!inputParser.parse("hello world").isValid());
    }

    @Test(expected = IllegalArgumentNumberForCommandException.class)
    public void parseExitInvalidArgumentsNumberTest() {
        InputParser inputParser = new InputParser();
        assertTrue(!inputParser.parse("exit world").isValid());
    }

    @Test(expected = IllegalArgumentNumberForCommandException.class)
    public void parseShowAllInvalidArgumentsNumberTest() {
        InputParser inputParser = new InputParser();
        assertTrue(!inputParser.parse("showall spotted dotted").isValid());
    }
}
