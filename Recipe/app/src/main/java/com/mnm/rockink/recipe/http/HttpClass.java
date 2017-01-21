package com.mnm.rockink.recipe.http;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by rockink on 1/21/17.
 */

public class HttpClass {

    OkHttpClient client;


    public HttpClass() {
        client = new OkHttpClient();
    }


    public String get(String url) throws IOException {

        url = "https://samples.clarifai.com/food.jpg";
        url = String.format(Constants.URL+"photos?url=%s", url);
        Request request = new Request.Builder()
                .url(url)
                .get().build();

        Response response= client.newCall(request).execute();
        String recipeString = response.body().string();
        return recipeString;

    }


    public OkHttpClient getClient() {
        return client;
    }
}
