package com.example.questiontypes01;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

    private EditText editTextEmail;
    private EditText editTextInt;
    private EditText editTextDate;

    Calendar myCalendar;



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

        editTextEmail = findViewById(R.id.editText_input_email);
        editTextInt = findViewById(R.id.editText_tb_integer);
        editTextDate = findViewById(R.id.editText_tb_datepicker);

        rowOptions.setVisibility(View.GONE);
        rowOptions2.setVisibility(View.GONE);
        rowOptions3.setVisibility(View.GONE);

        rowBody.setOnClickListener(this);
        rowBody2.setOnClickListener(this);
        rowBody3.setOnClickListener(this);

        editTextEmail.addTextChangedListener(new TextState(editTextEmail) {
            @Override
            public void feedback(String type, boolean isValid, String errorMsg) {
                if (editTextEmail.getText().toString().trim().length() == 0) {
                    return;
                } else {
                    if (isValid) {
                        Toast.makeText(QuestionsActivity.this, "valid email", Toast.LENGTH_SHORT).show();
                    } else {
                        //Toast.makeText(QuestionsActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                        Log.v("EMAIL", "" + errorMsg);
                    }
                }
            }
        });

        editTextInt.addTextChangedListener(new TextState(editTextInt) {
            @Override
            public void feedback(String type, boolean isValid, String errorMsg) {
                if (editTextInt.getText().toString().trim().length() == 0) {
                    return;
                } else {
                    if (isValid) {
                        Toast.makeText(QuestionsActivity.this, "valid integer", Toast.LENGTH_SHORT).show();
                    } else {
                        //Toast.makeText(QuestionsActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                        Log.v("INTEGER", "" + errorMsg);
                    }
                }
            }
        });

        myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                myCalendar.set(Calendar.YEAR, i);
                myCalendar.set(Calendar.MONTH, i1);
                myCalendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabel();
            }
        };

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(QuestionsActivity.this, R.style.SpinnerDatePickerDialogTheme, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    // https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext
    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

        editTextDate.setText(sdf.format(myCalendar.getTime()));
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
