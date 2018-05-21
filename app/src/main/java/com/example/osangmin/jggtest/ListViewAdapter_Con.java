package com.example.osangmin.jggtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by osangmin on 2017. 9. 21..
 */
// 공고 등록 관련 ListView

public class ListViewAdapter_Con extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ListViewItem_Con> listViewItemList = new ArrayList<>();

    // ListViewAdapter의 생성자
    public ListViewAdapter_Con() {

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
            convertView = inflater.inflate(R.layout.listview_item_con, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView companyName = (TextView) convertView.findViewById(R.id.companyName);
        TextView postState = (TextView) convertView.findViewById(R.id.postState);
        TextView workTitle = (TextView) convertView.findViewById(R.id.workTitle);
        TextView workTerm = (TextView) convertView.findViewById(R.id.workTerm);
        TextView workLocation = (TextView) convertView.findViewById(R.id.workLocation);
        TextView totalNum = (TextView) convertView.findViewById(R.id.totalNum);
        TextView postID = (TextView) convertView.findViewById(R.id.postID);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ListViewItem_Con listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        companyName.setText(listViewItem.getCompanyNameText());
        postState.setText(listViewItem.getPostState());
        workTitle.setText(listViewItem.getWorkTitle());
        workTerm.setText(listViewItem.getWorkTerm());
        workLocation.setText(listViewItem.getWorkLocation());
        totalNum.setText(String.valueOf(listViewItem.getTotalNum()));
        postID.setText(String.valueOf(listViewItem.getPostIDText()));

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

    public String getcompanyName(int position){
        return listViewItemList.get(position).getCompanyNameText();
    }

    public String getpostState(int position){
        return listViewItemList.get(position).getPostState();
    }

    public String getworkTitle(int position){
        return listViewItemList.get(position).getWorkTitle();
    }

    public String getworkTerm(int position){
        return listViewItemList.get(position).getWorkTerm();
    }

    public String getworkLocation(int position){
        return listViewItemList.get(position).getWorkLocation();
    }

    public int gettotalNum(int position){
        return listViewItemList.get(position).getTotalNum();
    }

    public int getpostID(int position){
        return listViewItemList.get(position).getPostIDText();
    }


    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String companyName, String postState, String workTitle, String workTerm, String workLocation, int totalNum, int postID ) {
        ListViewItem_Con item = new ListViewItem_Con();
        item.setCompanyNameText(companyName);
        item.setPostState(postState);
        item.setWorkTitle(workTitle);
        item.setWorkTerm(workTerm);
        item.setWorkLocation(workLocation);
        item.setTotalNum(totalNum);
        item.setPostIDText(postID);

        listViewItemList.add(item);
    }
}
