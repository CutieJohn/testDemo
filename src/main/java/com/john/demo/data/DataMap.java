package com.john.demo.data;

import com.john.demo.entity.Account;
import com.john.demo.entity.Transaction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

/**
 * mock account and transaction data
 */
@Component
public class DataMap {

    private List<Account> accountList = new LinkedList<>();
    private List<Transaction> transactionList = new LinkedList<>();

    @PostConstruct
    public void initData(){
        initAccounts();
    }

    /* init accounts */
    private void initAccounts(){
        accountList.add(new Account(1,1001,1000,"2859382746585976123","John",true));
        accountList.add(new Account(2,1002,1000,"2859382746585976124","Jane",true));
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "DataMap{" +
                "accountList=" + accountList +
                ", transactionList=" + transactionList +
                '}';
    }
}
