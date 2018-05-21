package com.example.osangmin.jggtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Context.ACTIVITY_SERVICE;
import static com.example.osangmin.jggtest.LoginActivity.realToken;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListViewAdaper_Search adapter;
    ListView listview;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Adapter 생성
        adapter = new ListViewAdaper_Search() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) view.findViewById(R.id.listview2);

        listview.setAdapter(adapter);



        Button registerButton = (Button)view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String token= realToken;
                Log.d(ACTIVITY_SERVICE, token);
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setCancelable(false);
                                builder.setPositiveButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        getActivity().startActivity(intent);
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("간편등록에 성공했습니다.")
                                        .create()
                                        .show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setCancelable(false);
                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                });
                                builder.setMessage("간편등록에 실패했습니다.")
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
                SearchPostRequest searchPostRequest = new SearchPostRequest(token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(searchPostRequest);


            }
        });

//        리스트뷰를 보여주기 위한 백그라운드 작업
        new BackgroundTask().execute();


        return view;
    }


    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String target;

        @Override
        protected void onPreExecute(){
            target = "http://210.205.188.105/jgg_dev/searchList.php";
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
                JSONArray jsonArray = jsonObject.getJSONArray("searchList");
                int count = 0;
                String workerName, workerLocation, part, career1, career2, certi;
                int workerAge,searchID;

                while(count < jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    workerName = object.getString ("workerName");
                    workerLocation = object.getString ("workerLocation");
                    part = object.getString ("part");
                    career1 = object.getString ("career1");
                    career2 = object.getString ("career2");
                    certi = object.getString ("certi");
                    workerAge = object.getInt ("workerAge");
                    searchID = object.getInt ("searchID");
                    adapter.addItem(""+ workerName +"",  ""+ workerLocation +"", ""+ part +"", ""+ career1 + "", ""+ career2 + "", ""+ certi + "", Integer.parseInt(""+ workerAge + ""), Integer.parseInt(""+ searchID + "")) ;
                    adapter.notifyDataSetChanged();
                    count++;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //php에서 데이터 받아오는 부분





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
