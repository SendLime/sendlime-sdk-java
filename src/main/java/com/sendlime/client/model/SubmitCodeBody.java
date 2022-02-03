package com.sendlime.client.model;

import com.google.gson.annotations.SerializedName;

public class SubmitCodeBody{

	@SerializedName("code_length")
	private int codeLength;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("locale")
	private String locale;

	@SerializedName("brand")
	private String brand;

	public int getCodeLength(){
		return codeLength;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public String getLocale(){
		return locale;
	}

	public String getBrand(){
		return brand;
	}

	public SubmitCodeBody(String brand, String phoneNumber, String locale, int codeLength) {
		this.codeLength = codeLength;
		this.phoneNumber = phoneNumber;
		this.locale = locale;
		this.brand = brand;
	}
}