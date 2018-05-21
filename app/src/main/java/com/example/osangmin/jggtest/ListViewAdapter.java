package com.example.osangmin.jggtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by osangmin on 2017. 9. 6..
 */

public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;

    }
    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView age = (TextView) convertView.findViewById(R.id.age);
        TextView main1 = (TextView) convertView.findViewById(R.id.main1);
        TextView main2 = (TextView) convertView.findViewById(R.id.main2);
        TextView area = (TextView) convertView.findViewById(R.id.area);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        name.setText(listViewItem.getNameText());
        age.setText(listViewItem.getAgeText());
        main1.setText(listViewItem.getMain1Text());
        main2.setText(listViewItem.getMain2Text());
        area.setText(listViewItem.getAreaText());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;

    }

    public Object getName(int position){
        return listViewItemList.get(position).getNameText();
    }

    public Object getAge(int position){
        return listViewItemList.get(position).getAgeText();
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String name, String age, String main1, String main2, String area) {
        ListViewItem item = new ListViewItem();
        item.setNameText(name);
        item.setAgeText(age);
        item.setMain1Text(main1);
        item.setMain2Text(main2);
        item.setAreaText(area);

        listViewItemList.add(item);
    }



}
