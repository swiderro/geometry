package com.marcinswiderski.portfolio.areacalculator.model.result;

import java.util.List;

public class DefaultReport implements Result {
    protected final String LINE_SEPARATOR = "\n\n";
    protected final String header =
            "DEFAULT REPORT" + getLineSeparator();
    protected final String FIELD_DELIMITER = " ";
    private List<CommandResult> commandCache;

    public DefaultReport(List<CommandResult> commandCache) {
        this.commandCache = commandCache;
    }

    @Override
    public String getStringValue() {
        StringBuilder stringBuilder = new StringBuilder(getHeader());
        for (CommandResult commandResult : commandCache) {
            commandResult.setFieldDelimiter(getFieldDelimiter());
            stringBuilder.append(commandResult.toString()).append(getLineSeparator());
        }
        return stringBuilder.toString();
    }

    protected String getHeader() {
        return header;
    }

    protected String getLineSeparator() {
        return LINE_SEPARATOR;
    }

    protected String getFieldDelimiter() {
        return FIELD_DELIMITER;
    }
}
