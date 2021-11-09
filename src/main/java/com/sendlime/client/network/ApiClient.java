package com.sendlime.client.network;

import com.sendlime.client.common.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ApiClient {
    public static Comm5Api comm5Api = null;

    public static void getClient() {
        if (comm5Api == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();

            comm5Api = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Comm5Api.class);

        }
    }

    public synchronized static Comm5Api getInstance() {
        if (comm5Api == null) {
            getClient();
        }
        return comm5Api;
    }

}
