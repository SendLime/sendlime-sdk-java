package com.sendlime.client.auth;

public class AuthHolder {
    private final String apiKey;
    private final String apiSecret;

    public AuthHolder(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }


    public String getApiKey() {
        return apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }
}
