package com.marcinswiderski.portfolio.areacalculator.model.command.area;

import java.util.List;

public interface ArgumentsParser {
    ArgumentsParser parse(List<String> commandArguments);

    boolean isValid();

    List getArguments();
}
