package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SendMessageResponse {

	@SerializedName("result")
	private SendMessageResult result;

	@SerializedName("error_message")
	private String errorMessage;

	@SerializedName("success")
	private boolean success;

	@SerializedName("error_code")
	private String errorCode;

	public SendMessageResult getResult(){
		return result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public boolean isSuccess(){
		return success;
	}

	public String getErrorCode(){
		return errorCode;
	}

	public void copy(SendMessageResponse submitMessageResponse) {
		this.result = submitMessageResponse.result;
		this.errorMessage = submitMessageResponse.errorMessage;
		this.success = submitMessageResponse.success;
		this.errorCode = submitMessageResponse.errorCode;
	}
}