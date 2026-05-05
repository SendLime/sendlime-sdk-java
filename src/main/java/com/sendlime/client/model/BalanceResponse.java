package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class BalanceResponse {

    @SerializedName("data")
    private BalanceResult result;

    @SerializedName("error")
    private String error;

    @SerializedName("success")
    private boolean success;

    public BalanceResult getResult() {
        return result;
    }

    public String getErrorMessage() {
        return error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void copy(BalanceResponse balanceResponse) {
        this.result = balanceResponse.result;
        this.error = balanceResponse.error;
        this.success = balanceResponse.success;
    }
}
