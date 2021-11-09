package com.sendlime.client.sms;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sendlime.client.auth.AuthHolder;
import com.sendlime.client.model.SubmitTextBody;
import com.sendlime.client.model.SubmitTextResponse;
import com.sendlime.client.network.ApiClient;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.regex.Pattern;

/**
 * A client for talking to the SendLime SMS API. The standard way to obtain an instance of this class is to use
 * {@link com.sendlime.client.SendLimeClient#getSmsClient()}.
 */
public class SMSClient {
    private final AuthHolder authHolder;

    /**
     * Create a new SmsClient.
     * @param authHolder AuthHolder used to create a Sms network Request
     */
    public SMSClient(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    /**
     * Send an SMS message.
     *
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param to The number user intend to send.
     *
     * @param text The text user intend to send.
     *
     * @return SubmitTextResponse an object that contains the detail of the sms request
     *
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SubmitTextResponse sendMessage(String to, String text) throws IllegalStateException{
        toValidator(to);
        return sentNetworkRequest(new SubmitTextBody(authHolder.getApiKey(), authHolder.getApiSecret(), to, text));
    }

    /**
     * Send an SMS message.
     *
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param from The number user intend to send from.
     *
     * @param to The number user intend to send.
     *
     * @param text The text user intend to send.
     *
     * @return SubmitTextResponse an object that contains the detail of the sms request
     *
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SubmitTextResponse sendMessage(String from, String to, String text) throws IllegalStateException {
        toValidator(to);
        return sentNetworkRequest(new SubmitTextBody(authHolder.getApiKey(), authHolder.getApiSecret(), from, to, text));
    }

    private SubmitTextResponse sentNetworkRequest(SubmitTextBody sendMessageBody) {
        SubmitTextResponse sendMessageResponse = new SubmitTextResponse();

        try {
            Response<SubmitTextResponse> response = ApiClient.getInstance()
                    .sendMessage(sendMessageBody)
                    .execute();

            if (response.code() == 400) {
                Type type = new TypeToken<SubmitTextResponse>() {
                }.getType();
                assert response.errorBody() != null;
                sendMessageResponse.copy(new Gson().fromJson(response.errorBody().charStream(), type));
                System.out.println(sendMessageResponse.getErrorMessage());
            } else {
                assert response.body() != null;
                sendMessageResponse.copy(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendMessageResponse;
    }

    private void toValidator(String to) {
        if (!Pattern.compile("^8801[3-9]\\d{8}$").matcher(to).matches()) {
            throw new IllegalStateException("Invalid to provided");
        }
    }
}
