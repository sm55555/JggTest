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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFF9FAFF));
        //Action Bar 색깔 바꾸기


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.maintitle);
        // ActionBar Title 중앙 위치
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        // 상단바 왼쪽 옵션

        final Button OfferButton = (Button) findViewById(R.id.OfferButton);
        final Button SearchButton = (Button) findViewById(R.id.SearchButton);
        final Button ClosingButton = (Button) findViewById(R.id.ClosingButton);

        OfferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OfferButton.setTextColor(Color.parseColor("#007AFF"));
                SearchButton.setTextColor(Color.parseColor("#000000"));
                ClosingButton.setTextColor(Color.parseColor("#000000"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new OfferFragment());
                fragmentTransaction.commit();
            }
        });
        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OfferButton.setTextColor(Color.parseColor("#000000"));
                SearchButton.setTextColor(Color.parseColor("#007AFF"));
                ClosingButton.setTextColor(Color.parseColor("#000000"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new SearchFragment());
                fragmentTransaction.commit();
            }
        });
        ClosingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                OfferButton.setTextColor(Color.parseColor("#000000"));
                SearchButton.setTextColor(Color.parseColor("#000000"));
                ClosingButton.setTextColor(Color.parseColor("#007AFF"));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ClosingFragment());
                fragmentTransaction.commit();
            }
        });

        OfferButton.setTextColor(Color.parseColor("#007AFF"));
        SearchButton.setTextColor(Color.parseColor("#000000"));
        ClosingButton.setTextColor(Color.parseColor("#000000"));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, new OfferFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //상단 오른쪽 버튼 구현 관련
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_button) {
            Intent Intent = new Intent(MainActivity.this, SearchActivity.class);
            MainActivity.this.startActivity(Intent);
            return true;
        } else if (id == android.R.id.home){
            Intent Intent = new Intent(MainActivity.this, MenuActivity.class);
            MainActivity.this.startActivity(Intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //상단 오른쪽 버튼 함수



}
