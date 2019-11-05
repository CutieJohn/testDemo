package com.john.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.john.demo.dao.AccountDAO;
import com.john.demo.entity.Account;
import com.john.demo.entity.ResultData;
import com.john.demo.entity.Transaction;
import com.john.demo.exception.AccountException;
import com.john.demo.exception.CardException;
import com.john.demo.service.AccountService;
import com.john.demo.utils.HttpClient;
import com.john.demo.utils.ParamCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {



    @Autowired
    private AccountDAO accountDAO;


    @Override
    public Account checkEnabled(String cardNo) throws CardException {
        Account account = findByCard(cardNo);
        if (!account.isEnabled()){
            throw new CardException(1002,"Card is disabled!");
        }
        return account;
    }

    @Override
    public Account retrieveBalance(String cardNo) throws CardException {
        // param check, let's consume cardNo length is 19
        ParamCheck.checkCardNo(cardNo);

        // check if the account enabled
        Account account = checkEnabled(cardNo);
        return account;
    }

    @Override
    public Account findByCard(String cardNo) throws CardException {
        Account account = accountDAO.findByCardNo(cardNo);
        return account;
    }

    @Override
    public Account retrieveBalanceService(String cardNo) throws CardException {
        String httpUrl = "http://localhost:8080/account/retrieveBalance?cardNo="+cardNo;
        String result = HttpClient.doGet(httpUrl);
        // log
        //System.out.println(result);
        // parse json
        JSONObject jo1 = JSON.parseObject(result);
        if(!jo1.get("status").equals(ResultData.STATUS_SUCCESS)){
            Integer code =(int) jo1.get("errCode");
            String errMsg = (String)jo1.get("errMsg");
            throw new CardException(code,errMsg);
        };
        JSONObject body = jo1.getJSONObject("body");
        Account account = JSON.parseObject(body.toString(), Account.class);

        return account;
    }

    // @Transactional open transactional in real project
    @Override
    public void makeTransaction(Account accountFrom, Account accountTo, Double money) throws AccountException {
        // check if account from can make the transaction
        if (accountFrom.getBalance() < money){
            throw new AccountException(2001,"Balance is not enough!");
        }
        //do transaction
        try{
            // record new transaction record
            Transaction transaction = new Transaction();
            transaction.setFromCard(accountFrom.getCardNo());
            transaction.setToCard(accountTo.getCardNo());
            transaction.setMoney(money);
            transaction.setStatus(2); // pending
            // save transaction record

            // lock get lock in real project
            accountDAO.outMoney(accountFrom, money);
            accountDAO.addMoney(accountTo,money);

            // update transaction to 1 (success)
        }catch (Exception e){
            // rollback
            // update transaction to 0 ( fail ) 
            throw e;
        }finally {
            // unlock
        }


    }
}
