package com.john.demo.utils;

import com.john.demo.exception.CardException;

public class ParamCheck {


    public static void checkCardNo(String cardNo) throws CardException {
        if(null == cardNo || "".equals(cardNo)){
            throw new CardException(1001,"Invalid card number , please check !");
        }
        if( 19 != cardNo.length()){
            throw new CardException(1001,"Invalid card number , please check !");
        }
    }
}
