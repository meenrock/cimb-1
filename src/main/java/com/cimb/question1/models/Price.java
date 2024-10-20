package com.cimb.question1.models;

// Can use lombok data here to simplified the getter setter boilerplate
public class Price {
    public int amount;
    public int position;
    public int getAmount() {
        return amount;
    }
    public int getPosition() {
        return position;
    }
    public void setAmount(int newAmount) {
        this.amount = newAmount;
    }
    public void setPosition(int newPosition) {
        this.position = newPosition;
    }
}
