package com.john.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class CardException extends Exception {

    private int code;
    private String errMsg;

    public CardException(){
    }

    public CardException(int code, String errMsg) {
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
        return "ErrorCardNoException{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
