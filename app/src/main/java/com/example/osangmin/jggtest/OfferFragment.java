package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OfferFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OfferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CustomDialog mCustomDialog;
    ListViewAdapter_Con adapter;
    ListView listview;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OfferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OfferFragment newInstance(String param1, String param2) {
        OfferFragment fragment = new OfferFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        //fragment에 관련된 layout을 보여주기 위함

        // Adapter 생성
        adapter = new ListViewAdapter_Con() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listview);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClickView();


            }
        });

        new BackgroundTask().execute();

        return view;
    }

    public void onClickView() {
        mCustomDialog = new CustomDialog(getActivity(), "[다이얼로그 제목]",
                "다이얼로그 내용 표시하기", leftListener, rightListener);mCustomDialog.show();
    }


    private View.OnClickListener leftListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "왼쪽버튼 클릭", Toast.LENGTH_SHORT).show();
            DialogRadio();
            mCustomDialog.dismiss();
        }
    };

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getActivity(), "오른쪽버튼 클릭", Toast.LENGTH_SHORT).show();
            mCustomDialog.dismiss();
        }
    };

    private void DialogRadio(){
        final String[] PhoneModels = {"iPhone", "Nokia", "Android"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(getActivity());
        alt_bld.setTitle("Select a Phone Model");
        alt_bld.setSingleChoiceItems(PhoneModels, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getActivity(), "Phone Model = "+PhoneModels[item], Toast.LENGTH_SHORT).show();
                 dialog.cancel();
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }



    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute(){
            target = "http://210.205.188.105/jgg_dev/offerList.php";
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
                JSONArray jsonArray = jsonObject.getJSONArray("dataLine");
                int count = 0;
                String companyName, postState, workTitle, workTerm, workLocation;
                int totalNum, postID;
                while(count < jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    companyName = object.getString ("companyName");
                    postState = object.getString ("postState");
                    workTitle = object.getString ("workTitle");
                    workTerm = object.getString ("workTerm");
                    workLocation = object.getString ("workLocation");
                    totalNum = object.getInt ("totalNum");
                    postID = object.getInt("postID");
                    adapter.addItem(""+ companyName +"", ""+ postState +"", ""+ workTitle +"", ""+ workTerm +"", ""+ workLocation + "", Integer.parseInt(""+ totalNum + ""), Integer.parseInt(""+ postID + "")) ;
                    adapter.notifyDataSetChanged();
                    count++;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
