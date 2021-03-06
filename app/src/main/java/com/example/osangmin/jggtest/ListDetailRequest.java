package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 21..
 */

public class ListDetailRequest  extends StringRequest {
    final static private String URL = "http://210.205.188.105/jgg_dev/listDetail.php";
    private Map<String, String> parameters;

    public ListDetailRequest(String postID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("postID",postID);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
