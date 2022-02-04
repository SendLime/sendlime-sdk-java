package com.sendlime.client.code;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sendlime.client.auth.AuthHolder;
import com.sendlime.client.common.Utils;
import com.sendlime.client.model.*;
import com.sendlime.client.network.ApiClient;
import com.sendlime.client.network.SendLimeApi;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Base64;

public class CodeClient {
    private final AuthHolder authHolder;
    private SendLimeApi sendLimeApi;

    /**
     * Create a new CodeClient.
     *
     * @param authHolder AuthHolder used to create a Sms network Request
     */
    public CodeClient(AuthHolder authHolder) {
        this.authHolder = authHolder;

        sendLimeApi = ApiClient.getInstance(Base64.getEncoder().encodeToString(
                (authHolder.getApiKey() + ":" + authHolder.getApiSecret()).getBytes()));
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
    public SendCodeResponse sendCode(String brand, String phoneNumber, String locale, int codeLength) throws IllegalStateException {
        Utils.toValidator(phoneNumber);
        return sendCodeRequest(new SendCodeBody(brand, phoneNumber, locale, codeLength));
    }

    /**
     * Send an SMS Code.
     * <p>
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param brand   The brand user intend to send.
     * @param phoneNumber The phone number user intend to send.
     * @return SubmitCodeResponse an object that contains the detail of the code request
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SendCodeResponse sendCode(String brand, String phoneNumber) {
        Utils.toValidator(phoneNumber);
        if (brand.isEmpty())
            throw new IllegalStateException("Brand name is missing!");
        return sendCodeRequest(new SendCodeBody(brand, phoneNumber, "bn-bd", 4));
    }

    /**
     * Send an SMS Code.
     * <p>
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param brand   The brand user intend to send.
     * @param phoneNumber The phone number user intend to send.
     * @param locale The local use intend to send.
     * @return SubmitCodeResponse an object that contains the detail of the code request
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SendCodeResponse sendCode(String brand, String phoneNumber, String locale) {
        Utils.toValidator(phoneNumber);
        if (brand.isEmpty())
            throw new IllegalStateException("Brand name is missing!");
        if (locale.isEmpty())
            throw new IllegalStateException("Locale is missing!");
        return sendCodeRequest(new SendCodeBody(brand, phoneNumber, locale, 4));
    }


    /**
     * Send an SMS Code.
     * <p>
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param brand   The brand user intend to send.
     * @param phoneNumber The phone number user intend to send.
     * @param codeLength the code length use intend to send.
     * @return SubmitCodeResponse an object that contains the detail of the code request
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public SendCodeResponse sendCode(String brand, String phoneNumber, int codeLength) {
        Utils.toValidator(phoneNumber);
        return sendCodeRequest(new SendCodeBody(brand, phoneNumber, "bn-bd", codeLength));
    }

    private SendCodeResponse sendCodeRequest(SendCodeBody submitCodeBody) {
        SendCodeResponse submitCodeResponse = new SendCodeResponse();

        try {
            Response<SendCodeResponse> response = sendLimeApi.submitCode(submitCodeBody).execute();
            if (response.code() != 200) {
                Type type = new TypeToken<SendCodeResponse>() {}.getType();
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
    /**
     * verify  Code.
     * <p>
     * This uses the supplied object to construct a request and post it to the SendLime API
     *
     * @param requestID     The request_id got from the sendCodeResponse.
     * @param code      The code received.
     * @return VerifyCodeResponse an object that contains the detail of the code request
     * @throws IllegalStateException if there is any wrong with given to or text
     */
    public VerifyCodeResponse verifyCode(String requestID, String code) throws IllegalStateException {
        if (requestID.isEmpty() || code.isEmpty())
            throw new IllegalStateException("You must provide both request_id and code");
        return sendVerifyCodeRequest(new VerifyCodeBody(requestID, code));
    }

    private VerifyCodeResponse sendVerifyCodeRequest(VerifyCodeBody verifyCodeBody) {
        VerifyCodeResponse verifyCodeResponse = new VerifyCodeResponse();

        try {
            Response<VerifyCodeResponse> response = sendLimeApi.verifyCode(verifyCodeBody).execute();
            if (response.code() != 200) {
                Type type = new TypeToken<VerifyCodeResponse>() {}.getType();
                assert response.errorBody() != null;
                verifyCodeResponse.copy(new Gson().fromJson(response.errorBody().charStream(), type));
            } else {
                assert response.body() != null;
                verifyCodeResponse.copy(response.body());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return verifyCodeResponse;
    }
}
