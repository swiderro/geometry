package com.marcinswiderski.portfolio.areacalculator.model.command.showall;

import com.marcinswiderski.portfolio.areacalculator.model.result.*;

import java.util.List;

public class ShowAllExecutor {
    private List<CommandResult> commandCache;

    public ShowAllExecutor(List<CommandResult> commandCache) {
        this.commandCache = commandCache;
    }

    public Result execute(List<Report> arguments) {
        if (arguments.isEmpty()) {
            return new DefaultReport(commandCache);
        } else {
            Report report = arguments.get(0);
            switch (report) {
                case dotted:
                    return new DottedReport(commandCache);
                case dashed:
                    return new DashedReport(commandCache);
            }
            throw new IllegalArgumentException("No implementation for report: " + report.name());
        }
    }
}
