package com.example.osangmin.jggtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by osangmin on 2017. 8. 15..
 */

public class RegisterChoiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerchoice);
        hideActionBar();
        //액션바 숨기기
        Button companyRegisterButton = (Button)findViewById(R.id.companyRegisterButton);
        Button workerRegisterButton = (Button)findViewById(R.id.workerRegisterButton);


        companyRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(RegisterChoiceActivity.this, CompanyRegisterActivity.class);
                RegisterChoiceActivity.this.startActivity(Intent);
            }
        });

        workerRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(RegisterChoiceActivity.this, WorkerRegister1Activity.class);
                RegisterChoiceActivity.this.startActivity(Intent);
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
