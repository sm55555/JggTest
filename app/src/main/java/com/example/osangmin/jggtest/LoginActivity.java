package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by osangmin on 2017. 8. 15..
 */

public class LoginActivity extends AppCompatActivity {
    static String realToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        hideActionBar();
        //액션바 숨기기
        final EditText ID = (EditText) findViewById(R.id.idText);
        final EditText PW = (EditText) findViewById(R.id.passwordText);



        Button registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent choiceIntent = new Intent(LoginActivity.this, RegisterChoiceActivity.class);
                LoginActivity.this.startActivity(choiceIntent);
            }
        });

        Button workerloginButton = (Button)findViewById(R.id.workerloginButton);
        workerloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String workerID= ID.getText().toString();
                final String workerPW = PW.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String tempToken = jsonResponse.getString("token");
                                Log.d(ACTIVITY_SERVICE, "토큰이당");
                                Log.d(ACTIVITY_SERVICE, tempToken);
                                realToken=tempToken;
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        LoginActivity.this.startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("로그인에 성공했습니다.")
                                        .create()
                                        .show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("로그인에 실패했습니다.")
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
                LoginRequest loginRequest = new LoginRequest(workerID, workerPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

        Button companyloginButton = (Button)findViewById(R.id.companyloginButton);
        companyloginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String companyID= ID.getText().toString();
                final String companyPW = PW.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String tempToken = jsonResponse.getString("token");
                                Log.d(ACTIVITY_SERVICE, tempToken);
                                realToken=tempToken;
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(LoginActivity.this, CompanyMainActivity.class);
                                        LoginActivity.this.startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("로그인에 성공했습니다.")
                                        .create()
                                        .show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("로그인에 실패했습니다.")
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
                CompanyLoginRequest companyLoginRequest = new CompanyLoginRequest(companyID, companyPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(companyLoginRequest);
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

