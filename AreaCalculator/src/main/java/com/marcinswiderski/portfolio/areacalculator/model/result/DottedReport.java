package com.marcinswiderski.portfolio.areacalculator.model.result;

import java.util.List;

public class DottedReport extends DefaultReport {

    protected final String LINE_SEPARATOR = "............................................................\n\n";
    protected final String header =
            "DOTTED REPORT" + LINE_SEPARATOR;

    public DottedReport(List<CommandResult> commandCache) {
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
