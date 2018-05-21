package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by osangmin on 2017. 8. 21..
 */

public class Post4Activity extends AppCompatActivity {
    String token = LoginActivity.realToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post4);
        hideActionBar();

        Intent Intent =getIntent();
        final String workTitle = Intent.getStringExtra("workTitle");
        final String workTermStart = Intent.getStringExtra("workTermStart");
        final String workTermFinish = Intent.getStringExtra("workTermFinish");
        final String scaleGround = Intent.getStringExtra("scaleGround");
        final String scaleUnderground = Intent.getStringExtra("scaleUnderGround");
        final String location1 = Intent.getStringExtra("location1");
        final String location2 = Intent.getStringExtra("location2");
        final String workLocationDetail = Intent.getStringExtra("workLocationDetail");
        //post1
        final String careerPart = Intent.getStringExtra("careerPart");
        final String careerPeriod = Intent.getStringExtra("careerPeriod");
        final String certi = Intent.getStringExtra("certi");
        final String deadLine = Intent.getStringExtra("deadLine");
        final String payroll = Intent.getStringExtra("payroll");
        final String workPart1 = Intent.getStringExtra("work1");
        final String workPart2 = Intent.getStringExtra("work2");
        final String workPart3 = Intent.getStringExtra("work3");
        final String workPart4 = Intent.getStringExtra("work4");
        final String workPart5 = Intent.getStringExtra("work5");
        final String workPart6 = Intent.getStringExtra("work6");
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
        final String staffPhone1 = Intent.getStringExtra("staffPhone1");
        final String staffPhone2 = Intent.getStringExtra("staffPhone2");
        final String staffPhone3 = Intent.getStringExtra("staffPhone3");
        final String staffPhone4 = Intent.getStringExtra("staffPhone4");
        final String staffPhone5 = Intent.getStringExtra("staffPhone5");
        final String staffPhone6 = Intent.getStringExtra("staffPhone6");
        final String staffPhone7 = Intent.getStringExtra("staffPhone7");
        final String staffPhone8 = Intent.getStringExtra("staffPhone8");
        final String staffPhone9 = Intent.getStringExtra("staffPhone9");
        final String staffPhone10 = Intent.getStringExtra("staffPhone10");
        //post3


        final TextView normalState = (TextView)findViewById(R.id.normalState);
        final TextView emergencyState = (TextView)findViewById(R.id.emergencyState);
        final TextView constructionText = (TextView)findViewById(R.id.construction);
        final TextView informationText = (TextView)findViewById(R.id.information);
        final Spinner noticeSpinnerText = (Spinner)findViewById(R.id.noticeSpinner);
        ArrayAdapter noticeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.state, android.R.layout.simple_spinner_item);
        noticeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noticeSpinnerText.setAdapter(noticeSpinnerAdapter);

        noticeSpinnerText.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    emergencyState.setVisibility(View.GONE);
                    normalState.setVisibility(View.VISIBLE);
                }else{
                    emergencyState.setVisibility(View.VISIBLE);
                    normalState.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button preButton = (Button)findViewById(R.id.preButton);
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String construction = constructionText.getText().toString();
                String information = informationText.getText().toString();
                String postState = noticeSpinnerText.getSelectedItem().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(Post4Activity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(Post4Activity.this, CompanyMainActivity.class);
                                        Post4Activity.this.startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("공고 등록에 성공했습니다.")
                                        .create()
                                        .show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Post4Activity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("공고 등록에 실패했습니다.")
                                        .create()
                                        .show();

                            }
                        }
                        catch(JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                PostRequest postRequest = new PostRequest(token,workTitle, workTermStart, workTermFinish, location1, location2, workLocationDetail, scaleGround, scaleUnderground, careerPart, careerPeriod, certi, deadLine, payroll, workPart1, workPay1, workNum1, workPart2, workPay2, workNum2, workPart3, workPay3, workNum3, workPart4, workPay4, workNum4, workPart5, workPay5, workNum5, workPart6, workPay6, workNum6, staffPhone1, staffPhone2, staffPhone3, staffPhone4, staffPhone5, staffPhone6, staffPhone7, staffPhone8, staffPhone9, staffPhone10, information, construction, postState, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Post4Activity.this);
                queue.add(postRequest);



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
