package com.john.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static Object buildResponse(String msg, String code, Map resultMap){
        Map<String, Object> responseMap = new HashMap();
        responseMap.put("msg",msg);
        responseMap.put("code",code);
        responseMap.put("data",resultMap);
        return  responseMap;
    }}
