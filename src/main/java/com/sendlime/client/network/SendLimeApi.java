package com.sendlime.client.network;

import com.sendlime.client.model.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SendLimeApi {
    @POST("sms/")
    Call<SubmitMessageResponse> submitMessage(@Body SubmitMessageBody submitMessageBody);

    @POST("verify/")
    Call<SubmitCodeResponse> submitCode(@Body SubmitCodeBody submitCodeBody);

    @POST("verify/check/")
    Call<VerifyCodeResponse> verifyCode(@Body VerifyCodeBody verifyCodeBody);
}
