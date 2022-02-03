package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("to")
	private String to;

	@SerializedName("request_id")
	private String requestId;

	@SerializedName("status")
	private String status;

	@SerializedName("attempts")
	private int attempts;

	public String getTo(){
		return to;
	}

	public String getRequestId(){
		return requestId;
	}

	public String getStatus(){
		return status;
	}

	public int getAttempts(){
		return attempts;
	}
}