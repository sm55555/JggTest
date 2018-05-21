package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 12..
 */

public class WorkerValidateRequest extends StringRequest {

    final static private String URL = "http://drk0830.cafe24.com/jgg_dev/workerValidate.php";
    //final static private String URL = "http://192.168.35.26:8080/Login.php";
    private Map<String, String> parameters;

    public WorkerValidateRequest(String workerID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("workerID",workerID);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
