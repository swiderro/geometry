package com.marcinswiderski.portfolio.areacalculator.model.result;


import java.util.List;

public class DashedReport extends DefaultReport {

    protected final String LINE_SEPARATOR = "____________________________________________________________\n\n";
    protected final String header =
            "DASHED REPORT" + LINE_SEPARATOR;

    public DashedReport(List<CommandResult> commandCache) {
        super(commandCache);
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
