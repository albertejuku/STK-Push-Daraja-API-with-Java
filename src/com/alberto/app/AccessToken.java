package com.alberto.app;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;


/**
 *
 * @author Ejuku A. I
 */
public class AccessToken {

    public AccessToken() {
    }

    /**
     *
     * @return access token
     */
    public static String accessToken() {

        // create the authorization
        // as specified by the docs, we should create our Base64.encode(consumer_key + ":" + consumer_secret)
        byte[] str = (Config.CONSUMER_KEY + ":" + Config.CONSUMER_SECRET).getBytes(StandardCharsets.UTF_8);
        byte[] key = Base64.getEncoder().encode(str);

        StringBuilder auth = new StringBuilder();
        for (byte b : key) {
            auth.append((char) b);
        }

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .method("GET", null)
                .addHeader("Authorization", String.format("Basic %s", auth))
                .build();
        Response response = null;

        try {
            response= client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert response != null;
        byte[] res = new byte[0];
        try {
            res = Objects.requireNonNull(response.body()).bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        StringBuilder token = new StringBuilder();
        for (byte b : res) {
            token.append((char) b);
        }

        JsonObject jsonObject = (new JsonParser()).parse(String.valueOf(token)).getAsJsonObject();
        return jsonObject.get("access_token").toString().replace("\"", "");
        
    }
    
}
