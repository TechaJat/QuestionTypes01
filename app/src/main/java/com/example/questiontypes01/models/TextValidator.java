package com.example.questiontypes01.models;

import android.util.Patterns;
import android.widget.TextView;

import java.text.NumberFormat;

public class TextValidator {

    private TextView textView;
    private int input;
    private String errorMsg;

    public TextValidator(TextView textView) {
        this.textView = textView;

        this.errorMsg = "";
    }

    public boolean ValidEmail() {
        boolean isValid = false;

        // todo: test validate email
        isValid = Patterns.EMAIL_ADDRESS.matcher(textView.getText()).matches();

        return isValid;
    }

    public boolean ValidInteger() {
        boolean isValid = false;

        // todo: test validate integer
        try {
            input = Integer.parseInt(textView.getText().toString());
            isValid = true;
        } catch (NumberFormatException e) {
            errorMsg = "Please enter only numbers";
        }

        return isValid;
    }

    // to be put into view instead ...
    /*public boolean ValidIntegerRange(int min, int max) {
        boolean isInt = ValidInteger();
        boolean isValid = false;
        input = Integer.parseInt(textView.getText().toString());

        if (isInt) {
            if (input < min) {
                errorMsg = "The number cannot be less than " + min;
            } else if (input > max) {
                errorMsg = "The number cannot be greater than " + max;
            } else {
                isValid = true;
            }
        }

        return isValid;
    }*/

    public String getTextError() {
        return errorMsg;
    }
}
