package com.sendlime.client.network;

import com.sendlime.client.model.SubmitMessageBody;
import com.sendlime.client.model.SubmitMessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SendLimeApi {
    @POST("sms/")
    Call<SubmitMessageResponse> sendMessage(@Body SubmitMessageBody sendMessageBody);
}
