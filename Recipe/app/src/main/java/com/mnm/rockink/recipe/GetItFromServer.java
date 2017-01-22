package com.mnm.rockink.recipe;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.mnm.rockink.recipe.http.HttpClass;
import com.mnm.rockink.recipe.jsonData.Food;

import java.io.IOException;

public class GetItFromServer extends AsyncTask<Bitmap, Object, Food> {

    public interface GetItemFromServerInterface{
        void setFoodList(Food s);
    }

    private GetItemFromServerInterface mListener;
    HttpClass httpClient;

    public GetItFromServer(HttpClass httpClient, GetItemFromServerInterface mListener) {
        this.httpClient = httpClient;
        this.mListener = mListener;
    }

    @Override
    protected Food doInBackground(Bitmap... params) {
        try {
            return httpClient.get(params[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Food s) {
        Log.d(getClass().getCanonicalName() + " RECIPESS ", String.valueOf(s.getCount()));
        mListener.setFoodList(s);
    }
}
