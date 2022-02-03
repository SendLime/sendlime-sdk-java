package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class VerifyCodeResponse{

	@SerializedName("result")
	private VerifyCodeResult result;

	@SerializedName("error_message")
	private Object errorMessage;

	@SerializedName("success")
	private boolean success;

	@SerializedName("error_code")
	private Object errorCode;

	public VerifyCodeResult getResult(){
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

	public void copy(VerifyCodeResponse VerifyCodeResponse) {
		this.result = VerifyCodeResponse.result;
		this.errorMessage = VerifyCodeResponse.errorMessage;
		this.success = VerifyCodeResponse.success;
		this.errorCode = VerifyCodeResponse.errorCode;
	}
}