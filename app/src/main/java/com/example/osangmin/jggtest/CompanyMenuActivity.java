package com.example.osangmin.jggtest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.osangmin.jggtest.LoginActivity.realToken;

/**
 * Created by osangmin on 2017. 8. 17..
 */

public class CompanyMenuActivity extends AppCompatActivity {

    private TextView companyGradeText;
    private TextView pointText;

    //로딩중 변수
    private Handler mHandler;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companymenu);

        LinearLayout noticeButton = (LinearLayout) findViewById(R.id.noticeButton);
        LinearLayout serviceCenterText = (LinearLayout) findViewById(R.id.serviceCenterText);
        LinearLayout workRegisterButton = (LinearLayout) findViewById(R.id.workRegisterButton);
        LinearLayout checkButton = (LinearLayout) findViewById(R.id.checkButton);
        LinearLayout companyModifyButton = (LinearLayout) findViewById(R.id.companyModifyButton);
        LinearLayout companyArticleButton = (LinearLayout) findViewById(R.id.companyArticleButton);

        companyGradeText = (TextView) findViewById(R.id.companyGrade);
        pointText = (TextView)findViewById(R.id.pointText);


        companyModifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(CompanyMenuActivity.this, CompanyModifyActivity.class);
                CompanyMenuActivity.this.startActivity(Intent);
            }
        });

        companyArticleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(CompanyMenuActivity.this, CompanyArticleActivity.class);
                CompanyMenuActivity.this.startActivity(Intent);
            }
        });

        workRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CompanyMenuActivity.this, "공고등록", Toast.LENGTH_SHORT).show();
                Intent Intent = new Intent(CompanyMenuActivity.this, Post1Activity.class);
                CompanyMenuActivity.this.startActivity(Intent);
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(CompanyMenuActivity.this, "공지사항", Toast.LENGTH_SHORT).show();
                Intent Intent = new Intent(CompanyMenuActivity.this, NoticeActivity.class);
                CompanyMenuActivity.this.startActivity(Intent);
            }
        });

        serviceCenterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CompanyMenuActivity.this, "서비스 센터", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
//                startActivity(intent);
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(CompanyMenuActivity.this, CompanyCheckActivity.class);
                CompanyMenuActivity.this.startActivity(Intent);
            }
        });

        CompanyMenu(); //회원 정보 나타내는 함수
    }
    
    public void CompanyMenu(){
        //대기중 로딩 소스
        mHandler = new Handler();
        runOnUiThread(new Runnable()
        {
            @Override
            public void run() {
                mProgressDialog = ProgressDialog.show(CompanyMenuActivity.this,"", "잠시만 기다려 주세요.",true);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (mProgressDialog!=null&&mProgressDialog.isShowing()){
                                mProgressDialog.dismiss();
                            }
                        }
                        catch ( Exception e ) {
                            e.printStackTrace();
                        }
                    }
                }, 1000);
            }
        } );
        String token = realToken;
        Log.d(ACTIVITY_SERVICE, token);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        String companyName = jsonResponse.getString("companyName");
                        String companyGrade = jsonResponse.getString("companyGrade");
                        String point = jsonResponse.getString("point");
                        setTitle(companyName);
                        companyGradeText.setText(companyGrade);
                        pointText.setText(point);
                    } else {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        CompanyMenuRequest companyMenuRequest = new CompanyMenuRequest(token, responseListener);
        RequestQueue queue = Volley.newRequestQueue(CompanyMenuActivity.this);
        queue.add(companyMenuRequest);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_companymenu, menu);
        return true;
        //상단 오른쪽 버튼 구현 관련
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cancel_button) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //상단 오른쪽 버튼 함수

}
