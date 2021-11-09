package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SubmitTextBody {

	@SerializedName("api_key")
	private String apiKey;

	@SerializedName("text")
	private String text;

	@SerializedName("from")
	private String from;

	@SerializedName("to")
	private String to;

	@SerializedName("api_secret")
	private String apiSecret;

	public String getApiKey(){
		return apiKey;
	}

	public String getText(){
		return text;
	}

	public String getTo(){
		return to;
	}

	public String getApiSecret(){
		return apiSecret;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public SubmitTextBody(String apiKey, String apiSecret, String to, String text) {
		this.apiKey = apiKey;
		this.text = text;
		this.to = to;
		this.apiSecret = apiSecret;
	}

	public SubmitTextBody(String apiKey, String apiSecret, String from, String to, String text) {
		this.apiKey = apiKey;
		this.text = text;
		this.from = from;
		this.to = to;
		this.apiSecret = apiSecret;
	}
}