package com.marcinswiderski.portfolio.areacalculator.model.command;

import com.marcinswiderski.portfolio.areacalculator.model.result.Result;
import com.marcinswiderski.portfolio.areacalculator.view.View;
import com.marcinswiderski.portfolio.areacalculator.view.ViewFactory;

import java.util.List;

public interface CommandModel {
    Result execute(List<String> commandArguments);

    public default View getView() {
        return ViewFactory.getView(View.Types.STRING_ONE_LINE);
    }
}
