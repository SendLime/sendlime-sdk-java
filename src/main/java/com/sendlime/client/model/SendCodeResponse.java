package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SendCodeResponse {

	@SerializedName("result")
	private SendCodeResult result;

	@SerializedName("error_message")
	private Object errorMessage;

	@SerializedName("success")
	private boolean success;

	@SerializedName("error_code")
	private Object errorCode;

	public SendCodeResult getResult(){
		return result;
	}

	public Object getErrorMessage(){
		return errorMessage;
	}

	public boolean isSuccess(){
		return success;
	}

	public Object getErrorCode(){
		return errorCode;
	}

	public void copy(SendCodeResponse submitCodeResponse) {
		this.result = submitCodeResponse.result;
		this.errorMessage = submitCodeResponse.errorMessage;
		this.success = submitCodeResponse.success;
		this.errorCode = submitCodeResponse.errorCode;
	}
}