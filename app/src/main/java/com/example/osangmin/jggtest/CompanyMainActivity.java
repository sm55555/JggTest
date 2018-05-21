package com.example.osangmin.jggtest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CompanyMainActivity extends AppCompatActivity {

    //메뉴 눌렀을때 회원정보 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);



        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFF9FAFF));
        //Action Bar 색깔 바꾸기
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.maintitle);
        // ActionBar Title 중앙 위치
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        // 상단바 왼쪽 옵션

        final Button companyOfferButton = (Button) findViewById(R.id.companyOfferButton);
        final Button companySearchButton = (Button) findViewById(R.id.companySearchButton);
        final Button companyClosingButton = (Button) findViewById(R.id.companyClosingButton);
        final LinearLayout companynotice = (LinearLayout) findViewById(R.id.companynotice);

        companyOfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companynotice.setVisibility(View.GONE);
                companyOfferButton.setTextColor(Color.parseColor("#007AFF"));
                companySearchButton.setTextColor(Color.parseColor("#000000"));
                companyClosingButton.setTextColor(Color.parseColor("#000000"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.companyfragment, new CompanyOfferFragment());
                fragmentTransaction.commit();
            }
        });
        companySearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companynotice.setVisibility(View.GONE);
                companyOfferButton.setTextColor(Color.parseColor("#000000"));
                companySearchButton.setTextColor(Color.parseColor("#007AFF"));
                companyClosingButton.setTextColor(Color.parseColor("#000000"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.companyfragment, new CompanySearchFragment());
                fragmentTransaction.commit();
            }
        });
        companyClosingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                companynotice.setVisibility(View.GONE);
                companyOfferButton.setTextColor(Color.parseColor("#000000"));
                companySearchButton.setTextColor(Color.parseColor("#000000"));
                companyClosingButton.setTextColor(Color.parseColor("#007AFF"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.companyfragment, new CompanyClosingFragment());
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_companymain, menu);
        return true;
        //상단 오른쪽 버튼 구현 관련
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent Intent = null;
        if (id == R.id.company_action_button) {

            Intent = new Intent(CompanyMainActivity.this, CompanySearchActivity.class);
            CompanyMainActivity.this.startActivity(Intent);
            return true;
        } else if (id == android.R.id.home) {
            Intent = new Intent(CompanyMainActivity.this, CompanyMenuActivity.class);
            CompanyMainActivity.this.startActivity(Intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //상단 오른쪽 버튼 함수
}
