package com.john.demo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResultData implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int STATUS_SUCCESS = 200; // success

    public static final int STATUS_ERROR = 100; // status error

    public static final int STATUS_DEPRECATED = -1; // deprecated

    public static final int STATUS_HYSTRIX_FALLBACK = -2;

    private int status  = STATUS_SUCCESS;

    private int errCode;

    private String errMsg = "";

    private Object body;

    public ResultData(){
        super();
    }

    public ResultData(int status, int errCode, String errMsg) {
        this.status = status;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ResultData(int status, Object body) {
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "status=" + status +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                ", body=" + body +
                '}';
    }
}
