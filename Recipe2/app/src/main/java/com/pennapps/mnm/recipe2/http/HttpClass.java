package com.pennapps.mnm.recipe2.http;

import com.google.gson.Gson;
import com.mnm.rockink.recipe.jsonData.Food;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rockink on 1/21/17.
 */

public class HttpClass {

    OkHttpClient client;


    public HttpClass() {
        client = new OkHttpClient();
    }


    public Food get(String url) throws IOException {

        url = "https://samples.clarifai.com/food.jpg";
        url = String.format(Constants.URL+"getrecipe?url=%s", url);
        Request request = new Request.Builder()
                .url(url)
                .get().build();

        Response response= client.newCall(request).execute();
        String recipeString = response.body().string();
        Gson gson = new Gson();

        System.out.println(recipeString);
        Food food = gson.fromJson(recipeString, Food.class);
        return food;

    }


    public OkHttpClient getClient() {
        return client;
    }
}
