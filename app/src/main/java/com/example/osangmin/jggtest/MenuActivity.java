package com.example.osangmin.jggtest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
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

public class MenuActivity extends AppCompatActivity {
    private TextView workerGradeText;

    //로딩중 변수
    private Handler mHandler;
    private ProgressDialog mProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        LinearLayout checkButton = (LinearLayout)findViewById(R.id.checkButton);
        LinearLayout modifyButton = (LinearLayout)findViewById(R.id.modifyButton);
        LinearLayout serviceCenterText = (LinearLayout)findViewById(R.id.serviceCenterText);
        LinearLayout noticeButton = (LinearLayout)findViewById(R.id.noticeButton);

        workerGradeText = (TextView) findViewById(R.id.workerGradeText);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MenuActivity.this, CheckActivity.class);
                MenuActivity.this.startActivity(Intent);

            }
        });
        modifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(MenuActivity.this, ModifyActivity.class);
                MenuActivity.this.startActivity(Intent);
            }
        });
        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "공지사항", Toast.LENGTH_SHORT).show();
                Intent Intent = new Intent(MenuActivity.this, NoticeActivity.class);
                MenuActivity.this.startActivity(Intent);
            }
        });

        serviceCenterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuActivity.this, "서비스 센터", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                startActivity(intent);
            }
        });


        Menu(); //회원 정보 나타내는 함수






    }



    public void Menu(){
        //대기중 로딩 소스
        mHandler = new Handler();
        runOnUiThread(new Runnable()
        {
            @Override
            public void run() {
                mProgressDialog = ProgressDialog.show(MenuActivity.this,"", "잠시만 기다려 주세요.",true);
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
                        String workerName = jsonResponse.getString("workerName");
                        String workerGrade = jsonResponse.getString("workerGrade");
                        String point = jsonResponse.getString("point");
                        setTitle(workerName);
                        workerGradeText.setText(workerGrade);


                    } else {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        MenuRequest menuRequest = new MenuRequest(token, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MenuActivity.this);
        queue.add(menuRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
