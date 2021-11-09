package com.sendlime.client.network;

import com.sendlime.client.model.SubmitTextBody;
import com.sendlime.client.model.SubmitTextResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Comm5Api {
    @POST("sms")
    Call<SubmitTextResponse> sendMessage(@Body SubmitTextBody sendMessageBody);
}
