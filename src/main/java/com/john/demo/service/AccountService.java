package com.john.demo.service;

import com.john.demo.entity.Account;
import com.john.demo.exception.AccountException;
import com.john.demo.exception.CardException;

public interface AccountService {

    Account checkEnabled(String cardNo) throws CardException;

    Account retrieveBalance(String cardNo) throws CardException;

    Account findByCard(String cardNo) throws CardException;

    Account retrieveBalanceService(String cardNo) throws CardException;

    void makeTransaction(Account accountFrom, Account accountTo, Double money) throws AccountException;
}
