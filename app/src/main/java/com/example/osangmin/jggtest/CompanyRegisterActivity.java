package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

public class CompanyRegisterActivity extends AppCompatActivity {
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyregister);
        hideActionBar();
        //액션바 숨기기

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText passwordText2 = (EditText) findViewById(R.id.passwordText2);
        final EditText crNumText = (EditText) findViewById(R.id.crNumText);
        final EditText companyNameText = (EditText) findViewById(R.id.companyNameText);
        final EditText ceoText = (EditText) findViewById(R.id.ceoText);
        Button nextButton = (Button)findViewById(R.id.nextButton);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idText.getText().toString();
                String Password = passwordText.getText().toString();
                String crnum = crNumText.getText().toString();
                String companyName = companyNameText.getText().toString();
                String ceo = ceoText.getText().toString();

                Intent Intent = new Intent(CompanyRegisterActivity.this, CompanyRegister2Activity.class);
                Intent.putExtra("id", id);
                Intent.putExtra("password", Password);
                Intent.putExtra("crnum", crnum);
                Intent.putExtra("ceo", ceo);
                Intent.putExtra("companyname", companyName);
                CompanyRegisterActivity.this.startActivity(Intent);
            }
        });

        final Button validateButton = (Button)findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyID = idText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(CompanyRegisterActivity.this);
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .create()
                                        .show();
                                idText.setEnabled(false);
                                validate = true;
                                idText.setBackgroundColor(getResources().getColor(R.color.Gray));
                                validateButton.setBackgroundColor(getResources().getColor(R.color.Gray));
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(CompanyRegisterActivity.this);
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("사용할 수 없는 아이디입니다.")
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
                CompanyValidateRequest companyValidateRequest = new CompanyValidateRequest(companyID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CompanyRegisterActivity.this);
                queue.add(companyValidateRequest);
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
