package com.marcinswiderski.portfolio.areacalculator.model.command.showall;

import com.marcinswiderski.portfolio.areacalculator.model.command.area.ArgumentsParser;

import java.util.LinkedList;
import java.util.List;

public class ShowAllArgumentsParser implements ArgumentsParser {
    private boolean valid = false;
    private List<Report> arguments = new LinkedList<>();

    @Override
    public ArgumentsParser parse(List<String> commandArguments) {
        if (commandArguments.size() == 1) {
            valid = true;
            return this;
        } else {
            //will throw exception on unknown report
            Report report = Report.valueOf(commandArguments.get(1));
            arguments.add(report);
            valid = true;
            return this;
        }
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public List getArguments() {
        return arguments;
    }
}
