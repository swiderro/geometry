package com.marcinswiderski.portfolio.areacalculator.view;

import com.marcinswiderski.portfolio.areacalculator.view.View.Types;

public class ViewFactory {
    public static View getView(Types type) {
        switch (type) {
            case STRING_ONE_LINE:
                return new StringOneLineView();
        }
        throw new IllegalArgumentException("No view implemented for view type: " + type.name());
    }
}
