package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 12..
 */

public class CompanyLoginRequest extends StringRequest {

    final static private String URL = "http://210.205.188.105/jgg_dev/companyLogin.php";
    private Map<String, String> parameters;

    public CompanyLoginRequest(String companyID, String companyPW, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("companyID",companyID);
        parameters.put("companyPW",companyPW);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}