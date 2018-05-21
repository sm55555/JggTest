package com.example.osangmin.jggtest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by osangmin on 2017. 9. 5..
 */

public class NoticeActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        hideActionBar();




        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);


//        adapter.addItem("1",
//                "공지사항입니다", "2017-08-03") ;
//        // 두 번째 아이템 추가.
//        adapter.addItem("2",
//                "공지사항입니다", "2017-08-03") ;
//        // 세 번째 아이템 추가.
//        adapter.addItem("3",
//                "공지사항입니다", "2017-08-03") ;


        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute(){
            target = "http://10.3.67.225:8080/NoticeList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection  = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null)
                {
                     stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String noticeNumber, noticeContent, noticeDate;
                while(count < jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    noticeNumber = object.getString ("noticeNumber");
                    noticeContent = object.getString ("noticeContent");
                    noticeDate = object.getString ("noticeDate");
                    Log.d(ACTIVITY_SERVICE, noticeNumber);
                    Log.d(ACTIVITY_SERVICE, noticeContent);
                    Log.d(ACTIVITY_SERVICE, noticeDate);
//                    adapter.addItem(""+ noticeNumber +"", ""+ noticeContent +"", ""+ noticeDate +"") ;
                    adapter.notifyDataSetChanged();
                    count++;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //AppCompatActivity일때 액션바 없애기
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
