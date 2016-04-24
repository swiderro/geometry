package com.marcinswiderski.portfolio.areacalculator.model;

import com.marcinswiderski.portfolio.areacalculator.view.View;

import java.util.List;

public interface CommandModel {
    Result execute(List<String> commandArguments);

    View getView();
}
