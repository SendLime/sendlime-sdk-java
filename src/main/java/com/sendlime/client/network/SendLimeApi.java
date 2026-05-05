package com.sendlime.client.network;

import com.sendlime.client.model.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SendLimeApi {
    @POST("messages")
    Call<SendMessageResponse> submitMessage(@Body SendMessageBody submitMessageBody);

    @GET("balance")
    Call<BalanceResponse> getBalance();

    @POST("verify/")
    Call<SendCodeResponse> submitCode(@Body SendCodeBody submitCodeBody);

    @POST("verify/check/")
    Call<VerifyCodeResponse> verifyCode(@Body VerifyCodeBody verifyCodeBody);
}
