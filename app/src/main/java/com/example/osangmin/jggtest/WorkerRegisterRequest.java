package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 12..
 */

public class WorkerRegisterRequest extends StringRequest {

    final static private String URL = "http://210.205.188.105/jgg_dev/workerRegister.php";
    private Map<String, String> parameters;
    public WorkerRegisterRequest(String workerID, String workerPW, String workerName, int workerAge, String location1, String location2,  String mainPart, String middlePart, String careerPart1, String careerPeriod1, String careerPart2, String careerPeriod2, String certiPart1, String certiNum1, String certiPart2, String certiNum2, String former, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("workerID",workerID);
        parameters.put("workerPW",workerPW);
        parameters.put("workerName", workerName);
        parameters.put("workerAge", workerAge + "");
        parameters.put("location1", location1);
        parameters.put("location2", location2);
        parameters.put("mainPart",mainPart);
        parameters.put("middlePart",middlePart);
        parameters.put("careerPart1",careerPart1);
        parameters.put("careerPeriod1",careerPeriod1);
        parameters.put("careerPart2",careerPart2);
        parameters.put("careerPeriod2",careerPeriod2);
        parameters.put("certiPart1",certiPart1);
        parameters.put("certiNum1",certiNum1);
        parameters.put("certiPart2",certiPart2);
        parameters.put("certiNum2",certiNum2);
        parameters.put("former",former);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
