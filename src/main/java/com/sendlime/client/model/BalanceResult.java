package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class BalanceResult {

    @SerializedName("balance")
    private double balance;

    @SerializedName("currency")
    private String currency;

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }
}
