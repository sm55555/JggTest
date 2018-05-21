package com.example.osangmin.jggtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by osangmin on 2017. 9. 21..
 */

public class ListViewDetail extends AppCompatActivity {
//    static String realToken;

    String realpostID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_detail);

        TextView companynameText = (TextView) findViewById(R.id.companynameText);
        TextView postStateText = (TextView) findViewById(R.id.postStateText);
        TextView workTitleText = (TextView) findViewById(R.id.workTitleText);
        TextView workTermText = (TextView) findViewById(R.id.workTermText);
        TextView workLocation = (TextView) findViewById(R.id.workLocationText);
        TextView totalNumText = (TextView) findViewById(R.id.totalNumText);
        TextView postIDText = (TextView) findViewById(R.id.postIDText);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        companynameText.setText(intent.getStringExtra("companyname"));
        postStateText.setText(intent.getStringExtra("postState"));
        workTitleText.setText(intent.getStringExtra("workTitle"));
        workTermText.setText(intent.getStringExtra("workTerm"));
        workLocation.setText(intent.getStringExtra("workLocation"));
        totalNumText.setText(intent.getStringExtra("totalNum"));
        postIDText.setText(intent.getStringExtra("postID"));
        realpostID = intent.getStringExtra("postID");
        asdsadad();

    }

    public void asdsadad(){
        String postID =realpostID;
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response){

                try
                {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){

                        String companyName = jsonResponse.getString("companyName");
                        String postState = jsonResponse.getString("postState");
                        String workTitle = jsonResponse.getString("workTitle");
                        String workTerm = jsonResponse.getString("workTerm");
                        String workLocation = jsonResponse.getString("workLocation");
                        int totalNum = jsonResponse.getInt("totalNum");
                        int postID = jsonResponse.getInt("postID");

                        Log.d(ACTIVITY_SERVICE, companyName);
                        Log.d(ACTIVITY_SERVICE, postState);
                        Log.d(ACTIVITY_SERVICE, workTitle);
                        Log.d(ACTIVITY_SERVICE, workTerm);
                        Log.d(ACTIVITY_SERVICE, workLocation);
                        Log.d(ACTIVITY_SERVICE, String.valueOf(totalNum));
                        Log.d(ACTIVITY_SERVICE, String.valueOf(postID));
                    }
                    else
                    {

                    }
                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }
        };
        ListDetailRequest listDetailRequest = new ListDetailRequest(postID, responseListener);
        RequestQueue queue = Volley.newRequestQueue(ListViewDetail.this);
        queue.add(listDetailRequest);
    }




}