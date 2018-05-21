package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 18..
 */

public class PostRequest extends StringRequest {

    final static private String URL = "http://210.205.188.105/jgg_dev/offerPost.php";
    private Map<String, String> parameters;

    public PostRequest(String token, String workTitle, String workTermStart, String workTermFinish, String location1, String location2, String workLocationDetail, String scaleGround, String scaleUnderground, String careerPart, String careerPeriod, String certi, String deadLine, String payroll, String workPart1, String workPay1, String workNum1, String workPart2, String workPay2, String workNum2, String workPart3, String workPay3, String workNum3, String workPart4, String workPay4, String workNum4, String workPart5, String workPay5, String workNum5, String workPart6, String workPay6, String workNum6, String staffPhone1, String staffPhone2, String staffPhone3, String staffPhone4, String staffPhone5, String staffPhone6, String staffPhone7, String staffPhone8, String staffPhone9, String staffPhone10, String information, String construction, String postState, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("token",token);
        parameters.put("workTitle",workTitle);
        parameters.put("workTermStart",workTermStart);
        parameters.put("workTermFinish",workTermFinish);
        parameters.put("location1",location1);
        parameters.put("location2",location2);
        parameters.put("workLocationDetail",workLocationDetail);
        parameters.put("scaleGround",scaleGround);
        parameters.put("scaleUnderground",scaleUnderground);
        parameters.put("careerPart",careerPart);
        parameters.put("careerPeriod",careerPeriod);
        parameters.put("certi",certi);
        parameters.put("deadLine",deadLine);
        parameters.put("payroll",payroll);
        parameters.put("workPart1",workPart1);
        parameters.put("workPay1",workPay1);
        parameters.put("workNum1",workNum1);
        parameters.put("workPart2",workPart2);
        parameters.put("workPay2",workPay2);
        parameters.put("workNum2",workNum2);
        parameters.put("workPart3",workPart3);
        parameters.put("workPay3",workPay3);
        parameters.put("workNum3",workNum3);
        parameters.put("workPart4",workPart4);
        parameters.put("workPay4",workPay4);
        parameters.put("workNum4",workNum4);
        parameters.put("workPart5",workPart5);
        parameters.put("workPay5",workPay5);
        parameters.put("workNum5",workNum5);
        parameters.put("workPart6",workPart6);
        parameters.put("workPay6",workPay6);
        parameters.put("workNum6",workNum6);
        parameters.put("staffPhone1",staffPhone1);
        parameters.put("staffPhone2",staffPhone2);
        parameters.put("staffPhone3",staffPhone3);
        parameters.put("staffPhone4",staffPhone4);
        parameters.put("staffPhone5",staffPhone5);
        parameters.put("staffPhone6",staffPhone6);
        parameters.put("staffPhone7",staffPhone7);
        parameters.put("staffPhone8",staffPhone8);
        parameters.put("staffPhone9",staffPhone9);
        parameters.put("staffPhone10",staffPhone10);
        parameters.put("information",information);
        parameters.put("construction",construction);
        parameters.put("postState",postState);


    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
