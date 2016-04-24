package com.marcinswiderski.portfolio.areacalculator.model.result;

import java.util.List;
import java.util.stream.Collectors;

public class CommandResult {

    private String fieldDelimiter;
    private String result;
    private List<String> inputArguments;

    public CommandResult(List<String> inputArguments, String result) {
        this.result = result;
        this.inputArguments = inputArguments;
    }

    @Override
    public String toString() {
        return inputArguments.stream().collect(Collectors.joining(fieldDelimiter)) + " = " + result;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandResult)) return false;

        CommandResult that = (CommandResult) o;

        if (fieldDelimiter != null ? !fieldDelimiter.equals(that.fieldDelimiter) : that.fieldDelimiter != null)
            return false;
        if (!inputArguments.equals(that.inputArguments)) return false;
        if (!result.equals(that.result)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = fieldDelimiter != null ? fieldDelimiter.hashCode() : 0;
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + inputArguments.hashCode();
        return result1;
    }
}
