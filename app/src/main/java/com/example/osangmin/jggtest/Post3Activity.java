package com.example.osangmin.jggtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by osangmin on 2017. 8. 31..
 */

public class Post3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post3);
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
        //post1
        final String careerPart = Intent.getStringExtra("careerPart");
        final String careerPeriod = Intent.getStringExtra("careerPeriod");
        final String certi = Intent.getStringExtra("certi");
        final String deadLine = Intent.getStringExtra("deadLine");
        final String payroll = Intent.getStringExtra("payroll");
        final String work1 = Intent.getStringExtra("work1");
        final String work2 = Intent.getStringExtra("work2");
        final String work3 = Intent.getStringExtra("work3");
        final String work4 = Intent.getStringExtra("work4");
        final String work5 = Intent.getStringExtra("work5");
        final String work6 = Intent.getStringExtra("work6");
        final String workPay1 = Intent.getStringExtra("workPay1");
        final String workNum1 = Intent.getStringExtra("workNum1");
        final String workPay2 = Intent.getStringExtra("workPay2");
        final String workNum2 = Intent.getStringExtra("workNum2");
        final String workPay3 = Intent.getStringExtra("workPay3");
        final String workNum3 = Intent.getStringExtra("workNum3");
        final String workPay4 = Intent.getStringExtra("workPay4");
        final String workNum4 = Intent.getStringExtra("workNum4");
        final String workPay5 = Intent.getStringExtra("workPay5");
        final String workNum5 = Intent.getStringExtra("workNum5");
        final String workPay6 = Intent.getStringExtra("workPay6");
        final String workNum6 = Intent.getStringExtra("workNum6");
        //post2




        final LinearLayout manager2 = (LinearLayout)findViewById(R.id.manager2);
        final LinearLayout manager3 = (LinearLayout)findViewById(R.id.manager3);
        final LinearLayout manager4 = (LinearLayout)findViewById(R.id.manager4);
        final LinearLayout manager5 = (LinearLayout)findViewById(R.id.manager5);
        final LinearLayout manager6 = (LinearLayout)findViewById(R.id.manager6);
        final LinearLayout manager7 = (LinearLayout)findViewById(R.id.manager7);
        final LinearLayout manager8 = (LinearLayout)findViewById(R.id.manager8);
        final LinearLayout manager9 = (LinearLayout)findViewById(R.id.manager9);
        final LinearLayout manager10 = (LinearLayout)findViewById(R.id.manager10);

        Button managerPlusButton1 = (Button)findViewById(R.id.managerPlusButton1);
        managerPlusButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(manager2.getVisibility() == View.GONE){
                    manager2.setVisibility(View.VISIBLE);
                } else if(manager2.getVisibility() == View.VISIBLE && manager3.getVisibility() == View.GONE){
                    manager3.setVisibility(View.VISIBLE);
                } else if(manager3.getVisibility() == View.VISIBLE && manager4.getVisibility() == View.GONE){
                    manager4.setVisibility(View.VISIBLE);
                } else if(manager4.getVisibility() == View.VISIBLE && manager5.getVisibility() == View.GONE){
                    manager5.setVisibility(View.VISIBLE);
                } else if(manager5.getVisibility() == View.VISIBLE && manager6.getVisibility() == View.GONE){
                    manager6.setVisibility(View.VISIBLE);
                } else if(manager6.getVisibility() == View.VISIBLE && manager7.getVisibility() == View.GONE){
                    manager7.setVisibility(View.VISIBLE);
                } else if(manager7.getVisibility() == View.VISIBLE && manager8.getVisibility() == View.GONE){
                    manager8.setVisibility(View.VISIBLE);
                } else if(manager8.getVisibility() == View.VISIBLE && manager9.getVisibility() == View.GONE){
                    manager9.setVisibility(View.VISIBLE);
                } else if(manager9.getVisibility() == View.VISIBLE && manager10.getVisibility() == View.GONE) {
                    manager10.setVisibility(View.VISIBLE);
                }

            }
        });

        final Button managerDeleteButton2 = (Button)findViewById(R.id.managerDeleteButton2);
        final Button managerDeleteButton3 = (Button)findViewById(R.id.managerDeleteButton3);
        final Button managerDeleteButton4 = (Button)findViewById(R.id.managerDeleteButton4);
        final Button managerDeleteButton5 = (Button)findViewById(R.id.managerDeleteButton5);
        final Button managerDeleteButton6 = (Button)findViewById(R.id.managerDeleteButton6);
        final Button managerDeleteButton7 = (Button)findViewById(R.id.managerDeleteButton7);
        final Button managerDeleteButton8 = (Button)findViewById(R.id.managerDeleteButton8);
        final Button managerDeleteButton9 = (Button)findViewById(R.id.managerDeleteButton9);
        final Button managerDeleteButton10 = (Button)findViewById(R.id.managerDeleteButton10);
        //staffPhone1
        final EditText managerPhoneText1 = (EditText)findViewById(R.id.managerPhoneText1);
        final EditText managerPhoneText2 = (EditText)findViewById(R.id.managerPhoneText2);
        final EditText managerPhoneText3 = (EditText)findViewById(R.id.managerPhoneText3);
        final EditText managerPhoneText4 = (EditText)findViewById(R.id.managerPhoneText4);
        final EditText managerPhoneText5 = (EditText)findViewById(R.id.managerPhoneText5);
        final EditText managerPhoneText6 = (EditText)findViewById(R.id.managerPhoneText6);
        final EditText managerPhoneText7 = (EditText)findViewById(R.id.managerPhoneText7);
        final EditText managerPhoneText8 = (EditText)findViewById(R.id.managerPhoneText8);
        final EditText managerPhoneText9 = (EditText)findViewById(R.id.managerPhoneText9);
        final EditText managerPhoneText10 = (EditText)findViewById(R.id.managerPhoneText10);


        managerDeleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText2.setText("");
                manager2.setVisibility(View.GONE);
            }
        });
        managerDeleteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText3.setText("");
                manager3.setVisibility(View.GONE);
            }
        });
        managerDeleteButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText4.setText("");
                manager4.setVisibility(View.GONE);
            }
        });
        managerDeleteButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText5.setText("");
                manager5.setVisibility(View.GONE);
            }
        });
        managerDeleteButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText6.setText("");
                manager6.setVisibility(View.GONE);
            }
        });
        managerDeleteButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText7.setText("");
                manager7.setVisibility(View.GONE);
            }
        });
        managerDeleteButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText8.setText("");
                manager8.setVisibility(View.GONE);
            }
        });
        managerDeleteButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText9.setText("");
                manager9.setVisibility(View.GONE);
            }
        });
        managerDeleteButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managerPhoneText10.setText("");
                manager10.setVisibility(View.GONE);
            }
        });


        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String staffPhone1 = managerPhoneText1.getText().toString();
                String staffPhone2 = managerPhoneText2.getText().toString();
                String staffPhone3 = managerPhoneText3.getText().toString();
                String staffPhone4 = managerPhoneText4.getText().toString();
                String staffPhone5 = managerPhoneText5.getText().toString();
                String staffPhone6 = managerPhoneText6.getText().toString();
                String staffPhone7 = managerPhoneText7.getText().toString();
                String staffPhone8 = managerPhoneText8.getText().toString();
                String staffPhone9 = managerPhoneText9.getText().toString();
                String staffPhone10 = managerPhoneText10.getText().toString();

                Intent Intent = new Intent(Post3Activity.this, Post4Activity.class);
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
                Intent.putExtra("staffPhone1", staffPhone1);
                Intent.putExtra("staffPhone2", staffPhone2);
                Intent.putExtra("staffPhone3", staffPhone3);
                Intent.putExtra("staffPhone4", staffPhone4);
                Intent.putExtra("staffPhone5", staffPhone5);
                Intent.putExtra("staffPhone6", staffPhone6);
                Intent.putExtra("staffPhone7", staffPhone7);
                Intent.putExtra("staffPhone8", staffPhone8);
                Intent.putExtra("staffPhone9", staffPhone9);
                Intent.putExtra("staffPhone10", staffPhone10);
                //post3
                Post3Activity.this.startActivity(Intent);
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

    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //AppCompatActivity일때 액션바 없애기
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
