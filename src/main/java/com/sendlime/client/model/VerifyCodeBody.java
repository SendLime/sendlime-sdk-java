package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class VerifyCodeBody{

	@SerializedName("code")
	private String code;

	@SerializedName("request_id")
	private String requestId;

	public String getCode(){
		return code;
	}

	public String getRequestId(){
		return requestId;
	}

	public VerifyCodeBody(String requestId, String code) {
		this.code = code;
		this.requestId = requestId;
	}
}