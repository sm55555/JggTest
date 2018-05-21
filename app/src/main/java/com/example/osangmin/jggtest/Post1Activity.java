package com.example.osangmin.jggtest;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by osangmin on 2017. 8. 21..
 */

public class Post1Activity extends AppCompatActivity {
    String location1;
    String location2;
    int check_city=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post1);

        hideActionBar();

        final String[] seoul = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도붕구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중량구"};
        final String[] inchen = {"강화군", "계양구", "남구", "남동", "동구", "부평구", "서구", "연수", "옹진군", "중구"};
        final String[] gwawng = {"광산구", "남구", "동구", "북구", "서구"};
        final String[] daejeon ={"대덕구", "동구", "서구", "유성구", "중구"};
        final String[] daegu ={"남구", "달서구", "달성군", "동구", "북구", "서구", "수성구", "중구"};
        final String[] busan ={"강서구", "금정구", "기장군", "남구", "동구", "동래구", "부산진구", "북구","사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구"};
        final String[] ulsan ={"남구", "동구", "북구", "울주군", "중구"};
        final String[] gyeonggi ={"가평군", "고양시 덕양구", "고양시 일산동구", "고양시 일산서구", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시 분당구", "성남시 수정구", "성남시 중원구", "수원시 권선구", "수원시 영통구", "수원시 장안구",
                "수원시 팔달구", "시흥시", "안산시 단원구", "안산시 상록구", "안성시", "안성시 동안구", "안성시 만안구", "양주시", "양평군", "여주시", "연천군", "오산시", "용인시 수지구", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시", "용인시 처인구", "용인시 기흥구"};
        final String[] gangwon ={"강릉시", "고성군", "동해시", "삼척시", "속초시", "양구군", "양양군", "영월군", "원주시", "인제군", "정선군", "철원군", "춘천시", "태백시", "평창군", "홍천군", "화천군", "횡성군"};
        final String[] chungnam ={"계룡시", "공주시", "금산군", "논산시", "당진군", "보령시", "부여군", "서산시", "서천군", "아산시", "연기군", "예산군", "천안시", "청양군", "태만군", "홍성군"};
        final String[] chungbuk ={"괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "제천시", "증평군", "진천군", "청원군", "청주시 상당구", "청주시 흥덕구", "충주시"};

        final EditText workTitleText = (EditText)findViewById(R.id.workTitle);
        final EditText scaleGroundText = (EditText)findViewById(R.id.scaleGround);
        final EditText scaleUnderGroundText = (EditText)findViewById(R.id.scaleUnderGround);
        final EditText workLocationText = (EditText)findViewById(R.id.workLocation);
        final EditText workLocationDetaleText = (EditText)findViewById(R.id.workLocationDetale);
        final Button workTermStartSpinner = (Button)findViewById(R.id.workTermStartSpinner);
        final Button workTermFinishSpinner = (Button)findViewById(R.id.workTermFinishSpinner);

        workTermStartSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Post1Activity.this, listener, 2017, 9, 10);
                dialog.show();
            }
        });

        workTermFinishSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(Post1Activity.this, listener2, 2017, 9, 10);
                dialog.show();
            }
        });



        final Button cityButton = (Button)findViewById(R.id.city);
        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater= LayoutInflater.from(Post1Activity.this);
                view=inflater.inflate(R.layout.test, null);
                final ListView listView = (ListView)view.findViewById(R.id.ListView);
                final String[] items = { "서울특별시", "인천광역시", "광주광역시", "대전광역시", "대구광역시", "부산광역시", "울산광역시", "경기도", "강원도", "충청남도", "충청북도", "전라남도", "전라북도", "경상남도", "경상북도", "제주특별자치도", "세종특별자치시"};
                ArrayAdapter adapter_dest = new ArrayAdapter(Post1Activity.this,android.R.layout.simple_list_item_1,items);
                listView.setAdapter(adapter_dest);
                final AlertDialog.Builder builder = new AlertDialog.Builder(Post1Activity.this);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        check_city =i;
                        cityButton.setText(items[i]);
                        location1=items[i];
                    }

                });
                builder.setTitle("시를 설정해 주세요.")
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        final Button boroughButton = (Button)findViewById(R.id.borough);
        boroughButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater= LayoutInflater.from(Post1Activity.this);
                view=inflater.inflate(R.layout.test, null);
                String[] items = {""};
                if(check_city ==0){
                    items = seoul;
                } else if(check_city ==1){
                    items = inchen;
                } else if(check_city ==2){
                    items = gwawng;
                } else if(check_city ==3){
                    items = daejeon;
                } else if(check_city ==4){
                    items = daegu;
                } else if(check_city ==5){
                    items = busan;
                } else if(check_city ==6){
                    items = ulsan;
                } else if(check_city ==7){
                    items = gyeonggi;
                } else if(check_city ==8){
                    items = gangwon;
                } else if(check_city ==9){
                    items = chungnam;
                } else if(check_city ==10){
                    items = chungbuk;
                }
                final ListView listView = (ListView)view.findViewById(R.id.ListView);
                ArrayAdapter adapter_dest = new ArrayAdapter(Post1Activity.this,android.R.layout.simple_list_item_1,items);
                listView.setAdapter(adapter_dest);
                final AlertDialog.Builder builder = new AlertDialog.Builder(Post1Activity.this);
                final String[] finalItems = items;
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        boroughButton.setText(finalItems[i]);
                        location2=finalItems[i];
                    }

                });
                builder.setTitle("구를 설정해 주세요.")
                        .setCancelable(false)
                        .setView(view)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            }
        });


        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String workTitle = workTitleText.getText().toString();
                String workTermStart = workTermStartSpinner.getText().toString();
                String workTermFinish = workTermFinishSpinner.getText().toString();
                String scaleGround = scaleGroundText.getText().toString();
                String scaleUnderGround = scaleUnderGroundText.getText().toString();
                String workLocationDetail = workLocationDetaleText.getText().toString();

                Intent Intent = new Intent(Post1Activity.this, Post2Activity.class);
                Intent.putExtra("workTitle", workTitle);
                Intent.putExtra("workTermStart", workTermStart);
                Intent.putExtra("workTermFinish", workTermFinish);
                Intent.putExtra("scaleGround", scaleGround);
                Intent.putExtra("scaleUnderGround", scaleUnderGround);
                Intent.putExtra("location1", location1);
                Intent.putExtra("location2", location2);
                Intent.putExtra("workLocationDetail", workLocationDetail);
                Post1Activity.this.startActivity(Intent);
            }
        });


    }

    public DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            monthOfYear= monthOfYear+1;
            TextView workTermStartSpinner = (TextView)findViewById(R.id.workTermStartSpinner);
            workTermStartSpinner.setText(year + "-"+ monthOfYear + "-"+ dayOfMonth);
        }
    };

    public DatePickerDialog.OnDateSetListener listener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            monthOfYear= monthOfYear+1;
            TextView workTermFinishSpinner = (TextView)findViewById(R.id.workTermFinishSpinner);
            workTermFinishSpinner.setText(year + "-"+ monthOfYear + "-"+ dayOfMonth);
        }
    };


    private void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //AppCompatActivity일때 액션바 없애기
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
