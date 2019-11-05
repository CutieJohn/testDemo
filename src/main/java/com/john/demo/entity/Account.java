package com.john.demo.entity;

import org.springframework.stereotype.Component;

/**
 * mock entity for account
 * time ignored
 */
@Component
public class Account {

    // primary key
    private Integer accountId;

    // user whom this account belongs to
    private int userId;

    // balance
    private Double balance;

    // account number
    private String cardNo;

    // account name
    private String name;

    // is enabled
    private boolean isEnabled;

    public Account() {
    }

    public Account(int accountId, int userId, double balance, String cardNo, String name, boolean isEnabled) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
        this.cardNo = cardNo;
        this.name = name;
        this.isEnabled = isEnabled;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", balance=" + balance +
                ", cardNo='" + cardNo + '\'' +
                ", name='" + name + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
