package com.example.questiontypes01;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import com.example.questiontypes01.controllers.TextValidationController;

public abstract class TextState implements TextWatcher {

    private final TextView textView;
    private TextValidationController tvc;

    public TextState(TextView textView) {
        this.textView = textView;
        tvc = new TextValidationController(textView);
    }

    public abstract void feedback(TextView textView, String text, String type, boolean isValid, String errorMsg);

    @Override
    final public void afterTextChanged(Editable s) {
        String text = textView.getText().toString();
        String type;
        boolean isValid;
        String errorMsg;

        // todo: to controller
        type = tvc.getType();
        isValid = tvc.validate();
        errorMsg = tvc.getErrorMsg();

        // view defined actions
        feedback(textView, text, type, isValid, errorMsg);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
