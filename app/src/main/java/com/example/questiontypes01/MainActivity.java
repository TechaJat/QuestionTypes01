package com.example.questiontypes01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStartQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Slide(Gravity.LEFT));
        setContentView(R.layout.activity_main);

        btnStartQ = findViewById(R.id.button_start_questions);

        if(btnStartQ != null) {
            btnStartQ.setOnClickListener(this);
        }
    }

    private void startQuestions() {
        Intent intent = new Intent(this, QuestionsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button_start_questions:
                startQuestions();
                break;
        }
    }
}
