package com.example.questiontypes01.controllers;

import android.widget.TextView;

import com.example.questiontypes01.models.TextValidator;

public class TextValidationController {

    private TextView textView;
    private String errorMsg;
    private TextValidator validator;
    private String type;

    public TextValidationController(TextView textView) {
        this.textView = textView;
        validator = new TextValidator(textView);

    }

    public boolean validate() {
        boolean isValid = false;

        switch (type) {
            case "email":
                isValid = validator.ValidEmail();
                break;

            case "integer":
                isValid = validator.ValidInteger();
                break;

            default:
                break;
        }

        return isValid;
    }

    public String getErrorMsg() {
        return validator.getTextError();
    }

    public String getType() {
        String idName = textView.getResources().getResourceEntryName(textView.getId());
        String[] idFields = idName.split("_");
        type = idFields[2]; // viewtype_location_description, textView_input_email

        return type;
    }
}
