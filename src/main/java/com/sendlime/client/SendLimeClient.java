package com.sendlime.client;


import com.sendlime.client.auth.AuthHolder;
import com.sendlime.client.code.CodeClient;
import com.sendlime.client.sms.SMSClient;

/**
 * Top-level SendLime API client object.
 */

public class SendLimeClient {

    private final SMSClient smsClient;
    private final CodeClient codeClient;

    public SendLimeClient(Builder builder) {
        smsClient = new SMSClient(builder.authHolder);
        codeClient = new CodeClient(builder.authHolder);
    }

    public SMSClient getSmsClient() {
        return smsClient;
    }

    public CodeClient getCodeClient() {
        return codeClient;
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        private String apiKey;
        private String apiSecret;
        private AuthHolder authHolder;

        /**
         * When setting an apiKey, it is also expected that {@link #apiSecret(String)}  will also be set
         *
         * @param apiKey The API Key found in the dashboard for your account.
         *
         * @return The {@link Builder} to keep building.
         */
        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        /**
         * When setting an apiSecret, it is also expected that {@link #apiKey(String)} will also be set.
         *
         * @param apiSecret The Signature Secret found in the dashboard for your account.
         *
         * @return The {@link Builder} to keep building.
         */
        public Builder apiSecret(String apiSecret) {
            this.apiSecret = apiSecret;
            return this;
        }

        /**
         * @return a new {@link SendLimeClient} from the stored builder options.
         *
         * @throws IllegalStateException if credentials aren't provided in a valid pairing.
         */
        public SendLimeClient build() {
            authHolder = generateAuthHolder();
            return new SendLimeClient(this);
        }

        private AuthHolder generateAuthHolder() {
            if (apiKey.isEmpty() || apiSecret.isEmpty()) {
                throw new IllegalStateException("You must provide both apikey and secret");
            }

            return new AuthHolder(apiKey, apiSecret);
        }
    }
}