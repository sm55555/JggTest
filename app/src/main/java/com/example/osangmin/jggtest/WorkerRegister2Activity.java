package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by osangmin on 2017. 8. 16..
 */

public class WorkerRegister2Activity extends AppCompatActivity {
    private boolean validate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workerregister2);
        hideActionBar();
        //액션바 숨기기
        final Spinner mainPartSpinner = (Spinner)findViewById(R.id.mainPartSpinner);
        ArrayAdapter mainPartAdapter = ArrayAdapter.createFromResource(this,
                R.array.main, android.R.layout.simple_spinner_item);
        mainPartAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainPartSpinner.setAdapter(mainPartAdapter);

        //final String text1 = mainPartSpinner.getSelectedItem().toString();

        Intent Intent =getIntent();
        final String id = Intent.getStringExtra("id");
        final String password = Intent.getStringExtra("password");
        final String name = Intent.getStringExtra("name");
        final int age = Intent.getIntExtra("age",1024);
        final String location1 = Intent.getStringExtra("location1");
        final String location2 = Intent.getStringExtra("location2");

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
        final EditText certiNumText1 = (EditText)findViewById(R.id.certiNumText1);
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



        final LinearLayout certi2 = (LinearLayout)findViewById(R.id.certi2);
        final LinearLayout certi3 = (LinearLayout)findViewById(R.id.certi3);

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


        final TextView companySearchText = (TextView)findViewById(R.id.companySearchText);
        Button companySearch = (Button)findViewById(R.id.companySearchButton);
        companySearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String companyID = companySearchText.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(WorkerRegister2Activity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("존재하는 전공사입니다.")
                                        .create()
                                        .show();
                                validate = true;

                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(WorkerRegister2Activity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("존재하지 않는 전공사입니다.")
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
                FindFormerRequest findFormerRequest = new FindFormerRequest(companyID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(WorkerRegister2Activity.this);
                queue.add(findFormerRequest);
            }
        });




        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(ACTIVITY_SERVICE, id);
                Log.d(ACTIVITY_SERVICE, password);


                String mainPart = mainPartSpinner.getSelectedItem().toString();
                String middlePart = middlePartSpinner.getSelectedItem().toString();
                String career1 = careerSpinner1.getSelectedItem().toString();
                String careerPeriod1 = careerPeriodSpinner1.getSelectedItem().toString();
                String career2 = careerSpinner2.getSelectedItem().toString();
                String careerPeriod2 = careerPeriodSpinner2.getSelectedItem().toString();
                String certi1 = certiSpinner1.getSelectedItem().toString();
                String certiNum1 = certiNumText1.getText().toString();
                String certi2 = certiSpinner2.getSelectedItem().toString();
                String certiNum2 = certiNumText2.getText().toString();
                String former = companySearchText.getText().toString();

                Intent Intent2 = new Intent(WorkerRegister2Activity.this, WorkerRegister3Activity.class);
                Intent2.putExtra("id", id);
                Intent2.putExtra("password", password);
                Intent2.putExtra("name", name);
                Intent2.putExtra("age", age);
                Intent2.putExtra("location1", location1);
                Intent2.putExtra("location2", location2);
                Intent2.putExtra("mainPart", mainPart);
                Intent2.putExtra("middlePart", middlePart);
                Intent2.putExtra("career1", career1);
                Intent2.putExtra("careerPeriod1", careerPeriod1);
                Intent2.putExtra("career2", career2);
                Intent2.putExtra("careerPeriod2", careerPeriod2);
                Intent2.putExtra("certi1", certi1);
                Intent2.putExtra("certiNum1", certiNum1);
                Intent2.putExtra("certi2", certi2);
                Intent2.putExtra("certiNum2", certiNum2);
                Intent2.putExtra("former", former);


                WorkerRegister2Activity.this.startActivity(Intent2);

            }
        });

        Button preButton = (Button)findViewById(R.id.preButton);
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
