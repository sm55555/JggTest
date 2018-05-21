package com.example.osangmin.jggtest;

import android.content.Intent;
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

public class CompanySearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companysearch);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.searchtitlecompany);
        // ActionBar Title 중앙 위치
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFFF9FAFF));
        //배경색 바꾸기

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        // 상단바 왼쪽 옵션

        final Spinner MainPartSpinner = (Spinner)findViewById(R.id.MainPartSpinner);
        ArrayAdapter MainPartAdapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        MainPartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MainPartSpinner.setAdapter(MainPartAdapter);

        final Spinner MiddlePartSpinner = (Spinner)findViewById(R.id.MiddlePartSpinner);
        ArrayAdapter MiddlePartAdapter = ArrayAdapter.createFromResource(this,
                R.array.middle, android.R.layout.simple_spinner_item);
        MiddlePartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MiddlePartSpinner.setAdapter(MiddlePartAdapter);

        final Spinner careerSpineer = (Spinner)findViewById(R.id.careerSpineer);
        ArrayAdapter careerAdapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        careerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpineer.setAdapter(careerAdapter);

        final Spinner careerPeriodSpineer = (Spinner)findViewById(R.id.careerPeriodSpineer);
        ArrayAdapter careerPeriod = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        careerPeriod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerPeriodSpineer.setAdapter(careerPeriod);

        final Spinner certiSpinner = (Spinner)findViewById(R.id.certiSpinner);
        ArrayAdapter certiAdapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner.setAdapter(certiAdapter);

        final Spinner ageSpinner = (Spinner)findViewById(R.id.ageSpinner);
        ArrayAdapter agePeriod = ArrayAdapter.createFromResource(this,
                R.array.age, android.R.layout.simple_spinner_item);
        agePeriod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setAdapter(agePeriod);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            Intent Intent = new Intent(CompanySearchActivity.this, CompanyMainActivity.class);
            CompanySearchActivity.this.startActivity(Intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
