package com.example.osangmin.jggtest;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by osangmin on 2017. 8. 17..
 */

public class SearchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.searchtitle);
        // ActionBar Title 중앙 위치
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFF9FAFF));
        //배경색 바꾸기

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        // 상단바 왼쪽 옵션

        final Spinner locationSpinner = (Spinner)findViewById(R.id.locationSpinner);
        ArrayAdapter locationAdapter = ArrayAdapter.createFromResource(this,
                R.array.location, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        final Spinner yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.searchyear, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        final Spinner monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this,
                R.array.month, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthAdapter);

        final Spinner daySpinner = (Spinner)findViewById(R.id.daySpinner);
        ArrayAdapter dayAdapter = ArrayAdapter.createFromResource(this,
                R.array.day, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(dayAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }//왼쪽 버튼 구현!
}
