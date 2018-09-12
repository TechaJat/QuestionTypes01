package com.example.questiontypes01;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.questiontypes01.models.TextValidator;

public abstract class TextState implements TextWatcher {

    private final TextView textView;
    private TextValidator textValidator;

    public TextState(TextView textView) {
        this.textView = textView;
    }

    public abstract void feedback(String type, boolean isValid, String errorMsg);

    @Override
    final public void afterTextChanged(Editable s) {
        textValidator = new TextValidator(textView);
        String type;
        boolean isValid;
        String errorMsg;

        type = textValidator.getType();
        isValid = textValidator.validate();
        errorMsg = textValidator.getErrorMsg();

        // view defined actions
        feedback(type, isValid, errorMsg);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
