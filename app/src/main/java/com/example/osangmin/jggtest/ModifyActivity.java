package com.example.osangmin.jggtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by osangmin on 2017. 9. 5..
 */

public class ModifyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        // 상단바 왼쪽 옵션

        final Spinner mainPartSpinner = (Spinner)findViewById(R.id.mainPartSpinner);
        ArrayAdapter mainPartAdapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        mainPartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainPartSpinner.setAdapter(mainPartAdapter);

        //final String text1 = mainPartSpinner.getSelectedItem().toString();


        final Spinner middlePartSpinner = (Spinner)findViewById(R.id.middlePartSpinner);
        ArrayAdapter middlePartAdapter = ArrayAdapter.createFromResource(this,
                R.array.middle, android.R.layout.simple_spinner_item);
        middlePartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        middlePartSpinner.setAdapter(middlePartAdapter);
        //주특기 입력

        final Spinner careerSpinner1 = (Spinner)findViewById(R.id.careerSpinner1);
        ArrayAdapter career1Adapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        career1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpinner1.setAdapter(career1Adapter);

        final Spinner careerPeriodSpinner1 = (Spinner)findViewById(R.id.careerPeriodSpinner1);
        ArrayAdapter careerPeriod1Adapter = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        careerPeriod1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerPeriodSpinner1.setAdapter(careerPeriod1Adapter);
        //첫번째 경력

        final Spinner careerSpinner2 = (Spinner)findViewById(R.id.careerSpinner2);
        final ArrayAdapter career2Adapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        career2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpinner2.setAdapter(career2Adapter);

        final Spinner careerPeriodSpinner2 = (Spinner)findViewById(R.id.careerPeriodSpinner2);
        ArrayAdapter careerPeriod2Adapter = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        careerPeriod2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerPeriodSpinner2.setAdapter(careerPeriod1Adapter);
        //두번째 경력

        final Spinner careerSpinner3 = (Spinner)findViewById(R.id.careerSpinner3);
        ArrayAdapter career3Adapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        career3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerSpinner3.setAdapter(career1Adapter);

        final Spinner careerPeriodSpinner3 = (Spinner)findViewById(R.id.careerPeriodSpinner3);
        ArrayAdapter careerPeriod3Adapter = ArrayAdapter.createFromResource(this,
                R.array.year, android.R.layout.simple_spinner_item);
        careerPeriod3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        careerPeriodSpinner3.setAdapter(careerPeriod3Adapter);
        //세번째 경력

        final LinearLayout career2 = (LinearLayout)findViewById(R.id.career2);
        final LinearLayout career3 = (LinearLayout)findViewById(R.id.career3);
        // 경력 레이아웃

        final Spinner certiSpinner1 = (Spinner)findViewById(R.id.certiSpinner1);
        ArrayAdapter certiSpinner1Adapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinner1Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner1.setAdapter(certiSpinner1Adapter);
        //첫번째 자격증

        final Spinner certiSpinner2 = (Spinner)findViewById(R.id.certiSpinner2);
        ArrayAdapter certiSpinner2Adapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner2.setAdapter(certiSpinner2Adapter);
        final EditText certiNumText2 = (EditText)findViewById(R.id.certiNumText2);
        //두번째 자격증

        final Spinner certiSpinner3 = (Spinner)findViewById(R.id.certiSpinner3);
        ArrayAdapter certiSpinner3Adapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinner3Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner3.setAdapter(certiSpinner3Adapter);
        final EditText certiNumText3 = (EditText)findViewById(R.id.certiNumText3);
        //세번째 자격증

        final Spinner certiSpinner4 = (Spinner)findViewById(R.id.certiSpinner4);
        ArrayAdapter certiSpinner4Adapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinner4Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner4.setAdapter(certiSpinner4Adapter);
        final EditText certiNumText4 = (EditText)findViewById(R.id.certiNumText4);
        //네번째 자격증

        final Spinner certiSpinner5 = (Spinner)findViewById(R.id.certiSpinner5);
        ArrayAdapter certiSpinner5Adapter = ArrayAdapter.createFromResource(this,
                R.array.certi, android.R.layout.simple_spinner_item);
        certiSpinner5Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        certiSpinner5.setAdapter(certiSpinner5Adapter);
        final EditText certiNumText5 = (EditText)findViewById(R.id.certiNumText5);
        //다섯번째 자격증

        final LinearLayout certi2 = (LinearLayout)findViewById(R.id.certi2);
        final LinearLayout certi3 = (LinearLayout)findViewById(R.id.certi3);
        final LinearLayout certi4 = (LinearLayout)findViewById(R.id.certi4);
        final LinearLayout certi5 = (LinearLayout)findViewById(R.id.certi5);
        // 경력 레이아웃

        Button careerPlusButton = (Button)findViewById(R.id.careerPlusButton);
        careerPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(career2.getVisibility() == View.GONE){
                    career2.setVisibility(View.VISIBLE);
                } else {
                    career3.setVisibility(View.VISIBLE);
                }

            }
        });
        // 경력 추가 부분

        Button careerDeleteButton1 = (Button)findViewById(R.id.careerDeleteButton1);
        careerDeleteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                careerSpinner2.setSelection(0);
                careerPeriodSpinner2.setSelection(0);
                career2.setVisibility(View.GONE);
            }
        });
        Button careerDeleteButton2 = (Button)findViewById(R.id.careerDeleteButton2);
        careerDeleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                careerSpinner3.setSelection(0);
                careerPeriodSpinner3.setSelection(0);
                career3.setVisibility(View.GONE);
            }
        });

        Button certiPlusButton = (Button)findViewById(R.id.certiPlusButton);
        certiPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(certi2.getVisibility() == View.GONE){
                    certi2.setVisibility(View.VISIBLE);
                } else if(certi2.getVisibility() == View.VISIBLE && certi3.getVisibility() == View.GONE){
                    certi3.setVisibility(View.VISIBLE);
                } else if(certi3.getVisibility() == View.VISIBLE && certi4.getVisibility() == View.GONE){
                    certi4.setVisibility(View.VISIBLE);
                } else if(certi4.getVisibility() == View.VISIBLE && certi5.getVisibility() == View.GONE){
                    certi5.setVisibility(View.VISIBLE);
                }
            }
        });

        Button certiDeleteButton1 = (Button)findViewById(R.id.certiDeleteButton1);
        certiDeleteButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                certiSpinner2.setSelection(0);
                certiNumText2.setText("");
                certi2.setVisibility(View.GONE);
            }
        });

        Button certiDeleteButton2 = (Button)findViewById(R.id.certiDeleteButton2);
        certiDeleteButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                certiSpinner3.setSelection(0);
                certiNumText3.setText("");
                certi3.setVisibility(View.GONE);
            }
        });

        Button certiDeleteButton3 = (Button)findViewById(R.id.certiDeleteButton3);
        certiDeleteButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                certiSpinner4.setSelection(0);
                certiNumText4.setText("");
                certi4.setVisibility(View.GONE);
            }
        });

        Button certiDeleteButton4 = (Button)findViewById(R.id.certiDeleteButton4);
        certiDeleteButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                certiSpinner5.setSelection(0);
                certiNumText5.setText("");
                certi5.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
