package com.sendlime.client.network;

import com.google.gson.GsonBuilder;
import com.sendlime.client.common.Constants;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    public static SendLimeApi comm5Api = null;

    public static void getClient(String credential) {
        if (comm5Api == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request original = chain.request();
                            Request request = original.newBuilder()
                                    .header("Content-Type", "application/json")
                                    .header("Authorization", "Basic " + credential)
                                    .method(original.method(), original.body())
                                    .build();

                            return chain.proceed(request);
                        }
                    })
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .build();

            comm5Api = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SendLimeApi.class);

        }
    }

    public synchronized static SendLimeApi getInstance(String crednetial) {
        if (comm5Api == null) {
            getClient(crednetial);
        }
        return comm5Api;
    }

}
