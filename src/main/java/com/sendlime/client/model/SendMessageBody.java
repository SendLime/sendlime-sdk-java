package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SendMessageBody {

	@SerializedName("message")
	private String message;

	@SerializedName("brand_id")
	private String brandId;

	@SerializedName("to")
	private String to;

	@SerializedName("channel")
	private String channel;


	public String getMessage(){
		return message;
	}

	public String getTo(){
		return to;
	}


	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public SendMessageBody(String to, String text) {
		this.message = text;
		this.to = to;
		this.channel = "sms";
	}

	public SendMessageBody(String from, String to, String text) {
		this.message = text;
		this.brandId = from;
		this.to = to;
		this.channel = "sms";
	}

	public SendMessageBody(String from, String to, String text, String channel) {
		this.message = text;
		this.brandId = from;
		this.to = to;
		this.channel = channel;
	}
}
