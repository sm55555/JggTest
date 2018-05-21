package com.example.osangmin.jggtest;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 29..
 */

public class FindFormerRequest extends StringRequest {
    final static private String URL = "http://210.205.188.105/jgg_dev/findFormer.php";
    private Map<String, String> parameters;

    public FindFormerRequest(String companyID, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("companyID",companyID);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
