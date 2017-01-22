package com.mnm.rockink.recipe.http;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.mnm.rockink.recipe.ImageUtil.ImageUtil;
import com.mnm.rockink.recipe.jsonData.Example;
import com.mnm.rockink.recipe.jsonData.Food;
import com.mnm.rockink.recipe.jsonData.Output;
import com.mnm.rockink.recipe.jsonData.Status__;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;


public class HttpClass {

    OkHttpClient client;



    class Body {
        String pic;

        public Body(String pic) {
            this.pic = pic;
        }
    }

    public HttpClass() {
        client = new OkHttpClient.Builder().readTimeout(0, TimeUnit.SECONDS)
        .build();


    }


    public Food get(Bitmap urll) throws IOException {


        String url;

        url = "https://samples.clarifai.com/food.jpg";

        String base64 = ImageUtil.convert(urll);
        error(base64);

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        Gson gson = new Gson();
        Body body = new Body(base64);
        String str = gson.toJson(body);

        System.out.println(str);

//        error(str);
        error("Before sending");

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("pic", base64)
                .build();

        url = String.format(Constants.URL+"getrecipe");



        Request request = new Request.Builder()
                .header("Content-Type", "application/json; charset=utf-8")
                .url(url)
                .post(requestBody)
                .build();

        Response response= client.newCall(request).execute();



        String recipeString = response.body().string();


        System.out.println(recipeString);
        Food food = gson.fromJson(recipeString, Food.class);


        return food;
    }

    private void error(String base64) {
        Log.d(getClass().getCanonicalName(), base64);
    }

    /*
    public void get(Bitmap bitmap) throws IOException {

<<<<<<< HEAD
    public Food get(final Bitmap bitmap) throws IOException {

        String url = String.format(Constants.URL+"getrecipe");


=======
        String url = "https://samples.clarifai.com/food.jpg";
        url = String.format(Constants.URL+"getrecipe");
>>>>>>> f85f350a9930c214c1c2f4f794dbdd9d06cf2ced


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
    */


    public OkHttpClient getClient() {
        return client;
    }
}
