package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class VerifyCodeResult {

	@SerializedName("price")
	private String price;

	@SerializedName("request_id")
	private String requestId;

	@SerializedName("status")
	private String status;

	public String getPrice(){
		return price;
	}

	public String getRequestId(){
		return requestId;
	}

	public String getStatus(){
		return status;
	}
}