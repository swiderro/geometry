package com.marcinswiderski.portfolio.areacalculator.model;

import java.util.List;

public interface ArgumentsParser {
    ArgumentsParser parse(List<String> commandArguments);

    boolean isValid();

    List getArguments();
}
