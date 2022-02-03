package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SubmitMessageResponse {

	@SerializedName("result")
	private Result result;

	@SerializedName("error_message")
	private String errorMessage;

	@SerializedName("success")
	private boolean success;

	@SerializedName("error_code")
	private String errorCode;

	public Result getResult(){
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

	public void copy(SubmitMessageResponse sendMessageResponse) {
		this.result = sendMessageResponse.result;
		this.errorMessage = sendMessageResponse.errorMessage;
		this.success = sendMessageResponse.success;
		this.errorCode = sendMessageResponse.errorCode;
	}
}