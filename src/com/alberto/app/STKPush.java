package com.alberto.app;

import okhttp3.*;

import java.io.IOException;
import java.util.Objects;


/**
 *
 * @author Ejuku A. I
 */
public class STKPush {
    public static void push() {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");

        TransactionDetails details = new TransactionDetails("1", "2547000*10");//mobile no (10 digit chars)

        System.out.println(details.transactionDetails());

        RequestBody body = RequestBody.create(mediaType, details.transactionDetails());
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + AccessToken.accessToken())
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResponseBody responseBody = Objects.requireNonNull(response).body();

        assert responseBody != null;
        byte[] bytes = new byte[0];
        try {
            bytes = responseBody.bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder transactionResponse = new StringBuilder();

        for (byte aByte : bytes) {
            transactionResponse.append((char) aByte);
        }

        System.out.println(transactionResponse);
    }
}
