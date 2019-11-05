package com.john.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class AccountException extends Exception {

    private int code;
    private String errMsg;

    public AccountException() {
        super();
    }

    public AccountException(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "AccountException{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
