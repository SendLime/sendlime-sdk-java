package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SendMessageResult {

    @SerializedName("price")
    private String price;

    @SerializedName("gateway_id")
    private String messageId;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("status")
    private String status;

    @SerializedName("network")
    private String network;

    @SerializedName("channel")
    private String channel;

    @SerializedName("credits_remaining")
    private double creditsRemaining;

    public String getPrice(){
        return price;
    }

    public String getMessageId(){
        return messageId;
    }

    public String getFrom(){
        return from;
    }

    public String getTo(){
        return to;
    }

    public String getStatus(){
        return status;
    }

    public String getNetwork(){
        return network;
    }

    public String getChannel(){
        return channel;
    }

    public double getCreditsRemaining(){
        return creditsRemaining;
    }
}
