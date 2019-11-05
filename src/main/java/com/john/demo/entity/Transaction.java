package com.john.demo.entity;

import org.springframework.stereotype.Component;

/**
 * mock entity for transaction record
 * time ignored
 */
@Component
public class Transaction {

    // primary key
    private Integer transactionId;

    // 1:transaction 2:consume
    private Integer style;

    // 0:fail 1:success 2:pending
    private Integer status;

    // money
    private double money;

    // account who gives the money
    private String fromCard;

    // account who receives the money
    private String toCard;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getFromCard() {
        return fromCard;
    }

    public void setFromCard(String fromCard) {
        this.fromCard = fromCard;
    }

    public String getToCard() {
        return toCard;
    }

    public void setToCard(String toCard) {
        this.toCard = toCard;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", style=" + style +
                ", status=" + status +
                ", money=" + money +
                ", fromCard='" + fromCard + '\'' +
                ", toCard='" + toCard + '\'' +
                '}';
    }
}
