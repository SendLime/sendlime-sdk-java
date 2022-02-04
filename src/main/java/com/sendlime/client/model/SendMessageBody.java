package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SendMessageBody {

	@SerializedName("text")
	private String text;

	@SerializedName("from")
	private String from;

	@SerializedName("to")
	private String to;


	public String getText(){
		return text;
	}

	public String getTo(){
		return to;
	}


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public SendMessageBody(String to, String text) {
		this.text = text;
		this.to = to;
	}

	public SendMessageBody(String from, String to, String text) {
		this.text = text;
		this.from = from;
		this.to = to;
	}
}