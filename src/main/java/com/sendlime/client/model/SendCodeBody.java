package com.sendlime.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

public class SendCodeBody {

	@SerializedName("code_length")
	private int codeLength;

	@SerializedName("phone_number")
	private String phoneNumber;

	@Nullable
	@SerializedName("locale")
	private String locale;

	@SerializedName("brand")
	private String brand;

	public Object getCodeLength(){
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

	public SendCodeBody(String brand, String phoneNumber, String locale, int codeLength) {
		this.codeLength = codeLength;
		this.phoneNumber = phoneNumber;
		this.locale = locale;
		this.brand = brand;
	}

	public SendCodeBody(String brand, String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.brand = brand;
	}

	public SendCodeBody(String brand, String phoneNumber, String locale) {
		this.phoneNumber = phoneNumber;
		this.locale = locale;
		this.brand = brand;
	}

	public SendCodeBody(String brand, String phoneNumber, int codeLength) {
		this.codeLength = codeLength;
		this.phoneNumber = phoneNumber;
		this.brand = brand;
	}
}