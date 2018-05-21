package com.example.osangmin.jggtest;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by osangmin on 2017. 8. 21..
 */

public class Post2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post2);

        hideActionBar();
        Intent Intent =getIntent();
        final String workTitle = Intent.getStringExtra("workTitle");
        final String workTermStart = Intent.getStringExtra("workTermStart");
        final String workTermFinish = Intent.getStringExtra("workTermFinish");
        final String scaleGround = Intent.getStringExtra("scaleGround");
        final String scaleUnderGround = Intent.getStringExtra("scaleUnderGround");
        final String location1 = Intent.getStringExtra("location1");
        final String location2 = Intent.getStringExtra("location2");
        final String workLocationDetail = Intent.getStringExtra("workLocationDetail");

        final EditText workPay1Text = (EditText)findViewById(R.id.workPay1);
        final EditText workNum1Text = (EditText)findViewById(R.id.workNum1);
        final EditText workPay2Text = (EditText)findViewById(R.id.workPay2);
        final EditText workNum2Text = (EditText)findViewById(R.id.workNum2);
        final EditText workPay3Text = (EditText)findViewById(R.id.workPay3);
        final EditText workNum3Text = (EditText)findViewById(R.id.workNum3);
        final EditText workPay4Text = (EditText)findViewById(R.id.workPay4);
        final EditText workNum4Text = (EditText)findViewById(R.id.workNum4);
        final EditText workPay5Text = (EditText)findViewById(R.id.workPay5);
        final EditText workNum5Text = (EditText)findViewById(R.id.workNum5);
        final EditText workPay6Text = (EditText)findViewById(R.id.workPay6);
        final EditText workNum6Text = (EditText)findViewById(R.id.workNum6);


        final Spinner careerSpinner = (Spinner)findViewById(R.id.careerSpinner);
        ArrayAdapter careerAdapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        careerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpinner.setAdapter(careerAdapter);

        final Spinner careerPeriodSpinner = (Spinner)findViewById(R.id.careerPeriodSpinner);
        ArrayAdapter careerPeriodAdapter = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        careerPeriodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerPeriodSpinner.setAdapter(careerPeriodAdapter);
        //경력

        final Spinner certiSpinner = (Spinner)findViewById(R.id.certiSpinner);
        ArrayAdapter certiSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner.setAdapter(certiSpinnerAdapter);
        //자격증

        final LinearLayout work2 =(LinearLayout)findViewById(R.id.work2);
        final LinearLayout work3 =(LinearLayout)findViewById(R.id.work3);
        final LinearLayout work4 =(LinearLayout)findViewById(R.id.work4);
        final LinearLayout work5 =(LinearLayout)findViewById(R.id.work5);
        final LinearLayout work6 =(LinearLayout)findViewById(R.id.work6);

        final Spinner workPart1Spinner = (Spinner)findViewById(R.id.workPart1);
        ArrayAdapter workPart1Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart1Spinner.setAdapter(workPart1Adapter);

        final Spinner workPart2Spinner = (Spinner)findViewById(R.id.workPart2);
        ArrayAdapter workPart2Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart2Spinner.setAdapter(workPart2Adapter);

        final Spinner workPart3Spinner = (Spinner)findViewById(R.id.workPart3);
        ArrayAdapter workPart3Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart3Spinner.setAdapter(workPart3Adapter);

        final Spinner workPart4Spinner = (Spinner)findViewById(R.id.workPart4);
        ArrayAdapter workPart4Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart4Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart4Spinner.setAdapter(workPart4Adapter);

        final Spinner workPart5Spinner = (Spinner)findViewById(R.id.workPart5);
        ArrayAdapter workPart5Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart5Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart5Spinner.setAdapter(workPart5Adapter);

        final Spinner workPart6Spinner = (Spinner)findViewById(R.id.workPart6);
        ArrayAdapter workPart6Adapter = ArrayAdapter.createFromResource(this,
                R.array.part, android.R.layout.simple_spinner_item);
        workPart6Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workPart6Spinner.setAdapter(workPart6Adapter);

        Button workDeleteButton2 = (Button)findViewById(R.id.workDeleteButton2);
        workDeleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workPart2Spinner.setSelection(0);
                workPay2Text.setText("");
                workNum2Text.setText("");
                work2.setVisibility(View.GONE);
            }
        });

        Button workDeleteButton3 = (Button)findViewById(R.id.workDeleteButton3);
        workDeleteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workPart3Spinner.setSelection(0);
                workPay3Text.setText("");
                workNum3Text.setText("");
                work3.setVisibility(View.GONE);
            }
        });

        Button workDeleteButton4 = (Button)findViewById(R.id.workDeleteButton4);
        workDeleteButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workPart4Spinner.setSelection(0);
                workPay4Text.setText("");
                workNum4Text.setText("");
                work4.setVisibility(View.GONE);
            }
        });

        Button workDeleteButton5 = (Button)findViewById(R.id.workDeleteButton5);
        workDeleteButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workPart5Spinner.setSelection(0);
                workPay5Text.setText("");
                workNum5Text.setText("");
                work5.setVisibility(View.GONE);
            }
        });

        Button workDeleteButton6 = (Button)findViewById(R.id.workDeleteButton6);
        workDeleteButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workPart6Spinner.setSelection(0);
                workPay6Text.setText("");
                workNum6Text.setText("");
                work6.setVisibility(View.GONE);
            }
        });

        Button workPlusButton = (Button)findViewById(R.id.workPlusButton);
        workPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(work2.getVisibility() == View.GONE){
                    work2.setVisibility(View.VISIBLE);
                } else if(work2.getVisibility() == View.VISIBLE && work3.getVisibility() == View.GONE){
                    work3.setVisibility(View.VISIBLE);
                } else if(work3.getVisibility() == View.VISIBLE && work4.getVisibility() == View.GONE){
                    work4.setVisibility(View.VISIBLE);
                } else if(work4.getVisibility() == View.VISIBLE && work5.getVisibility() == View.GONE){
                    work5.setVisibility(View.VISIBLE);
                } else if(work5.getVisibility() == View.VISIBLE && work6.getVisibility() == View.GONE) {
                    work6.setVisibility(View.VISIBLE);
                }

            }
        });


        final Button deadLineSpinner = (Button)findViewById(R.id.deadLineSpinner);
        final Button payrollSpinner = (Button)findViewById(R.id.payrollSpinner);
        //마감일, 급여지급일

        deadLineSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Post2Activity.this, listener, 2017, 9, 10);
                dialog.show();
            }
        });

        payrollSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Post2Activity.this, listener2, 2017, 9, 10);
                dialog.show();
            }
        });

        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String careerPart = careerSpinner.getSelectedItem().toString();
                String careerPeriod = careerPeriodSpinner.getSelectedItem().toString();
                String certi = certiSpinner.getSelectedItem().toString();
                String deadLine = deadLineSpinner.getText().toString();
                String payroll = payrollSpinner.getText().toString();
                String work1 = workPart1Spinner.getSelectedItem().toString();
                String work2 = workPart2Spinner.getSelectedItem().toString();
                String work3 = workPart3Spinner.getSelectedItem().toString();
                String work4 = workPart4Spinner.getSelectedItem().toString();
                String work5 = workPart5Spinner.getSelectedItem().toString();
                String work6 = workPart6Spinner.getSelectedItem().toString();
                String workPay1 = workPay1Text.getText().toString();
                String workNum1 = workNum1Text.getText().toString();
                String workPay2 = workPay2Text.getText().toString();
                String workNum2 = workNum2Text.getText().toString();
                String workPay3 = workPay3Text.getText().toString();
                String workNum3 = workNum3Text.getText().toString();
                String workPay4 = workPay4Text.getText().toString();
                String workNum4 = workNum4Text.getText().toString();
                String workPay5 = workPay5Text.getText().toString();
                String workNum5 = workNum5Text.getText().toString();
                String workPay6 =workPay6Text.getText().toString();
                String workNum6 = workNum6Text.getText().toString();

                Intent Intent = new Intent(Post2Activity.this, Post3Activity.class);
                Intent.putExtra("workTitle", workTitle);
                Intent.putExtra("workTermStart", workTermStart);
                Intent.putExtra("workTermFinish", workTermFinish);
                Intent.putExtra("scaleGround", scaleGround);
                Intent.putExtra("scaleUnderGround", scaleUnderGround);
                Intent.putExtra("location1", location1);
                Intent.putExtra("location2", location2);
                Intent.putExtra("workLocationDetail", workLocationDetail);
                //post1
                Intent.putExtra("careerPart", careerPart);
                Intent.putExtra("careerPeriod", careerPeriod);
                Intent.putExtra("certi", certi);
                Intent.putExtra("deadLine", deadLine);
                Intent.putExtra("payroll", payroll);
                Intent.putExtra("work1", work1);
                Intent.putExtra("work2", work2);
                Intent.putExtra("work3", work3);
                Intent.putExtra("work4", work4);
                Intent.putExtra("work5", work5);
                Intent.putExtra("work6", work6);
                Intent.putExtra("workPay1", workPay1);
                Intent.putExtra("workNum1", workNum1);
                Intent.putExtra("workPay2", workPay2);
                Intent.putExtra("workNum2", workNum2);
                Intent.putExtra("workPay3", workPay3);
                Intent.putExtra("workNum3", workNum3);
                Intent.putExtra("scaleUnderGround", scaleUnderGround);
                Intent.putExtra("workPay4", workPay4);
                Intent.putExtra("workNum4", workNum4);
                Intent.putExtra("workPay5", workPay5);
                Intent.putExtra("workNum5", workNum5);
                Intent.putExtra("workPay6", workPay6);
                Intent.putExtra("workNum6", workNum6);
                //post2
                Post2Activity.this.startActivity(Intent);
            }
        });

        Button preButton = (Button)findViewById(R.id.preButton);
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            TextView workTermStartSpinner = (TextView)findViewById(R.id.deadLineSpinner);
            monthOfYear= monthOfYear+1;
            workTermStartSpinner.setText(year + "-"+ monthOfYear + "-"+ dayOfMonth);
        }
    };

    public DatePickerDialog.OnDateSetListener listener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            monthOfYear= monthOfYear+1;
            TextView workTermFinishSpinner = (TextView)findViewById(R.id.payrollSpinner);
            workTermFinishSpinner.setText(year +"-"+ monthOfYear +"-"+ dayOfMonth);
        }
    };

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //AppCompatActivity일때 액션바 없애기
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
