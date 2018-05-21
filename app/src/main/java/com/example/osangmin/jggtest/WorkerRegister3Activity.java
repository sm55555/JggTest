package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by osangmin on 2017. 8. 16..
 */

public class WorkerRegister3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workerregister3);
        hideActionBar();
        //액션바 숨기기
        Intent Intent2 =getIntent();

        final String workerID = Intent2.getStringExtra("id");
        final String workerPW = Intent2.getStringExtra("password");
        final String workerName = Intent2.getStringExtra("name");
        final int workerAge = Intent2.getIntExtra("age",1024);
        final String location1 = Intent2.getStringExtra("location1");
        final String location2 = Intent2.getStringExtra("location2");
        final String mainPart = Intent2.getStringExtra("mainPart");
        final String middlePart = Intent2.getStringExtra("middlePart");
        final String careerPart1 = Intent2.getStringExtra("career1");
        final String careerPeriod1 = Intent2.getStringExtra("careerPeriod1");
        final String careerPart2 = Intent2.getStringExtra("career2");
        final String careerPeriod2 = Intent2.getStringExtra("careerPeriod2");
        final String certiPart1 = Intent2.getStringExtra("certi1");
        final String certiNum1 = Intent2.getStringExtra("certiNum1");
        final String certiPart2 = Intent2.getStringExtra("certi2");
        final String certiNum2 = Intent2.getStringExtra("certiNum2");
        final String former = Intent2.getStringExtra("former");



        final TextView termsText = (TextView)findViewById(R.id.termsText);
        final TextView privacyText = (TextView)findViewById(R.id.privacyText);
        Button termsButton = (Button)findViewById(R.id.termsButton);
        termsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(termsText.getVisibility() == View.GONE){
                    termsText.setVisibility(View.VISIBLE);
                }else{
                    termsText.setVisibility(View.GONE);
                }
            }
        });
        Button privacyButton = (Button)findViewById(R.id.privacyButton);
        privacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(privacyText.getVisibility() == View.GONE){
                    privacyText.setVisibility(View.VISIBLE);
                }else{
                    privacyText.setVisibility(View.GONE);
                }
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
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(WorkerRegister3Activity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(WorkerRegister3Activity.this, LoginActivity.class);
                                        WorkerRegister3Activity.this.startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("회원 등록에 성공했습니다.")
                                        .create()
                                        .show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(WorkerRegister3Activity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("회원 등록에 실패했습니다.")
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
                WorkerRegisterRequest workerRegisterRequest = new WorkerRegisterRequest(workerID, workerPW, workerName, workerAge, location1, location2, mainPart, middlePart, careerPart1, careerPeriod1, careerPart2, careerPeriod2, certiPart1, certiNum1, certiPart2, certiNum2, former, responseListener);
                RequestQueue queue = Volley.newRequestQueue(WorkerRegister3Activity.this);
                queue.add(workerRegisterRequest);

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
