package com.sendlime.client.code;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sendlime.client.auth.AuthHolder;
import com.sendlime.client.common.Utils;
import com.sendlime.client.model.SubmitCodeBody;
import com.sendlime.client.model.SubmitCodeResponse;
import com.sendlime.client.model.SubmitMessageBody;
import com.sendlime.client.model.SubmitMessageResponse;
import com.sendlime.client.network.ApiClient;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;

public class CodeClient {
    private final AuthHolder authHolder;

    /**
     * Create a new CodeClient.
     *
     * @param authHolder AuthHolder used to create a Sms network Request
     */
    public CodeClient(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    /**
     * Send an SMS Code.
     * <p>
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param brand   The brand user intend to send.
     * @param phoneNumber The phone number user intend to send.
     * @param locale The local use intend to send.
     * @param codeLength the code length use intend to send.
     * @return SubmitCodeResponse an object that contains the detail of the code request
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SubmitCodeResponse sendCode(String brand, String phoneNumber, String locale, int codeLength) throws IllegalStateException {
        Utils.toValidator(phoneNumber);
        return sendCodeRequest(new SubmitCodeBody(brand, phoneNumber, locale, codeLength));
    }

    private SubmitCodeResponse sendCodeRequest(SubmitCodeBody submitCodeBody) {
        SubmitCodeResponse submitCodeResponse = new SubmitCodeResponse();

        try {
            Response<SubmitCodeResponse> response = ApiClient.getInstance(Base64.getEncoder().encodeToString(
                            (authHolder.getApiKey() + ":" + authHolder.getApiSecret()).getBytes()))
                    .submitCode(submitCodeBody)
                    .execute();

            if (response.code() != 200) {
                Type type = new TypeToken<SubmitCodeResponse>() {}.getType();
                assert response.errorBody() != null;
                submitCodeResponse.copy(new Gson().fromJson(response.errorBody().charStream(), type));
            } else {
                assert response.body() != null;
                submitCodeResponse.copy(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return submitCodeResponse;
    }
}
