package com.example.osangmin.jggtest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by osangmin on 2017. 9. 12..
 */

public class CompanyRegisterRequest extends StringRequest {

    final static private String URL = "http://210.205.188.105/jgg_dev/companyRegister.php";  //서버의 기업회원 가입 php파일 위치연결
    private Map<String, String> parameters;

    public CompanyRegisterRequest(String companyID, String companyPW,  String crNum, String companyName, String ceoName, String location1, String location2, String companyAddrDetail, int elNum, String isFormer, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("companyID", companyID);
        parameters.put("companyPW", companyPW);
        parameters.put("crNum", crNum);
        parameters.put("companyName", companyName);
        parameters.put("ceoName", ceoName);
        parameters.put("location1", location1);
        parameters.put("location2", location2);
        parameters.put("companyAddrDetail", companyAddrDetail);
        parameters.put("elNum", elNum + "");
        parameters.put("isFormer", isFormer);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }

}
