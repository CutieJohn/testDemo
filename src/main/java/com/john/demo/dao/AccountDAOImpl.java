package com.john.demo.dao;

import com.john.demo.data.DataMap;
import com.john.demo.entity.Account;
import com.john.demo.exception.CardException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private DataMap dataMap;

    @Override
    public Account findByCardNo(String cardNo) throws CardException {
        Account account = null;
        List<Account> accountList = dataMap.getAccountList();
        for( Account a : accountList){
            if(a.getCardNo().equals(cardNo)){
                account = a;
            }
        }
        if( null == account){
            throw new CardException(1003,"Card does not exists!");
        }
        return account;
    }

    @Override
    public void outMoney(Account accountFrom, Double money) {
        List<Account> accountList = dataMap.getAccountList();
        accountFrom.setBalance(accountFrom.getBalance() - money);
        for (int i= 0; i < accountList.size();i++){
            if(accountList.get(i).getCardNo().equals(accountFrom.getCardNo())){
                accountList.set(i,accountFrom);
            }
        }

    }

    @Override
    public void addMoney(Account accountTo, Double money) {
        List<Account> accountList = dataMap.getAccountList();
        accountTo.setBalance(accountTo.getBalance() + money);
        for (int i= 0; i < accountList.size();i++){
            if(accountList.get(i).getCardNo().equals(accountTo.getCardNo())){
                accountList.set(i,accountTo);
            }
        }
    }
}
