package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SubmitMessageResult{

    @SerializedName("price")
    private String price;

    @SerializedName("message_id")
    private String messageId;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("status")
    private String status;

    @SerializedName("network")
    private String network;

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
}