package com.john.demo;

import com.alibaba.fastjson.JSONObject;
import com.john.demo.utils.HttpClient;
import junit.framework.TestCase;

public class DemoTest extends TestCase {

    public void testBalance() {
        String httpUrl = "http://localhost:8080/account/retrieveBalance?cardNo="+"2859382746585976123";
        String result = HttpClient.doGet(httpUrl);
        System.out.println(result);
    }

    public void testTransaction() throws Exception {
        String httpUrl = "http://localhost:8080/account/transactionForTest";
        JSONObject obj = new JSONObject();
        obj.put("fromCard","2859382746585976123");
        obj.put("toCard", "2859382746585976124");
        obj.put("money", 300D);

        String result = HttpClient.doPost(httpUrl, obj.toString());
        System.out.println(result);
    }
}
