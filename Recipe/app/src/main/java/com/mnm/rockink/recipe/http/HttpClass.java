package com.mnm.rockink.recipe.http;

import android.graphics.Bitmap;
import android.util.Base64;

import com.google.gson.Gson;
import com.mnm.rockink.recipe.jsonData.Food;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.PortUnreachableException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

import static com.mnm.rockink.recipe.R.id.url;

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


    public Food get(final Bitmap bitmap) throws IOException {

        String url = String.format(Constants.URL+"getrecipe");




        final MediaType mediaType = MediaType.parse("png");

        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return mediaType;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                sink.write(byteArray);
            }
        };


        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
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
