package com.example.questiontypes01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout rowBody;
    private TextView rowLabel;
    private RadioGroup rowOptions;
    private ImageView expandIcon;

    private LinearLayout rowBody2;
    private RadioGroup rowOptions2;
    private ImageView expandIcon2;

    private LinearLayout rowBody3;
    private RadioGroup rowOptions3;
    private ImageView expandIcon3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        rowBody = findViewById(R.id.linearLayout_rbGrid_rowBody);
        rowOptions = findViewById(R.id.radioGroup_rowLabel_options);
        expandIcon = findViewById(R.id.imageView_rowLabel_expand);

        rowBody2 = findViewById(R.id.linearLayout_rbGrid_rowBody2);
        rowOptions2 = findViewById(R.id.radioGroup_rowLabel_options2);
        expandIcon2 = findViewById(R.id.imageView_rowLabel_expand2);

        rowBody3 = findViewById(R.id.linearLayout_rbGrid_rowBody3);
        rowOptions3 = findViewById(R.id.radioGroup_rowLabel_options3);
        expandIcon3 = findViewById(R.id.imageView_rowLabel_expand3);

        rowOptions.setVisibility(View.GONE);
        rowOptions2.setVisibility(View.GONE);
        rowOptions3.setVisibility(View.GONE);

        rowBody.setOnClickListener(this);
        rowBody2.setOnClickListener(this);
        rowBody3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.v("Questions Activity", "a message");
        if (view.getId() == rowBody.getId()) {
            if (rowOptions.isShown()) {
                rowOptions.setVisibility(View.GONE);
                expandIcon.setBackgroundResource(R.drawable.ic_expand_more_black_24dp);
            } else {
                rowOptions.setVisibility(View.VISIBLE);
                expandIcon.setBackgroundResource(R.drawable.ic_expand_less_black_24dp);
            }
        } else if (view.getId() == rowBody2.getId()) {
            if (rowOptions2.isShown()) {
                rowOptions2.setVisibility(View.GONE);
                expandIcon2.setBackgroundResource(R.drawable.ic_expand_more_black_24dp);
            } else {
                rowOptions2.setVisibility(View.VISIBLE);
                expandIcon2.setBackgroundResource(R.drawable.ic_expand_less_black_24dp);
            }
        } else if (view.getId() == rowBody3.getId()) {
            if (rowOptions3.isShown()) {
                rowOptions3.setVisibility(View.GONE);
                expandIcon3.setBackgroundResource(R.drawable.ic_expand_more_black_24dp);
            } else {
                rowOptions3.setVisibility(View.VISIBLE);
                expandIcon3.setBackgroundResource(R.drawable.ic_expand_less_black_24dp);
            }
        }
    }
}
