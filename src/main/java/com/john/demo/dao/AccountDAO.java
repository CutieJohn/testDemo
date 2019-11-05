package com.john.demo.dao;

import com.john.demo.entity.Account;
import com.john.demo.exception.CardException;

public interface AccountDAO {
    Account findByCardNo(String cardNo) throws CardException;

    void outMoney(Account accountFrom, Double money);

    void addMoney(Account accountTo, Double money);
}
