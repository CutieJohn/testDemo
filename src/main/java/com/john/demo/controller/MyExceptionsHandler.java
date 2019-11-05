package com.john.demo.controller;

import com.alibaba.fastjson.JSON;
import com.john.demo.entity.ResultData;
import com.john.demo.exception.AccountException;
import com.john.demo.exception.CardException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionsHandler {

    @ExceptionHandler(CardException.class)// handle card exception
    @ResponseBody
    public String customGenericExceptionHnadler(CardException e){
        // log if needed
        return JSON.toJSONString(new ResultData(ResultData.STATUS_ERROR, e.getCode(), e.getErrMsg()));

    }

    @ExceptionHandler(AccountException.class) // handle account exception
    @ResponseBody
    public String customGenericExceptionHnadler(AccountException e){
        // log if needed
        return JSON.toJSONString(new ResultData(ResultData.STATUS_ERROR, e.getCode(), e.getErrMsg()));

    }

    @ExceptionHandler(Exception.class)// handle other exception
    @ResponseBody
    public String allExceptionHandler(Exception e){
        // log if needed
        return JSON.toJSONString(new ResultData(ResultData.STATUS_ERROR, 100, e.getMessage()));

    }
}
