package com.mnm.rockink.recipe;

import android.os.AsyncTask;
import android.util.Log;

import com.mnm.rockink.recipe.http.HttpClass;
import com.mnm.rockink.recipe.jsonData.Food;

import java.io.IOException;

/**
 * Created by rockink on 1/21/17.
 */

public class GetItFromServer extends AsyncTask<String, Object, Food> {

    private final URLForm.OnFragmentInteractionListener mListener;
    HttpClass httpClient;

    public GetItFromServer(HttpClass httpClient, URLForm.OnFragmentInteractionListener mListener) {
        this.httpClient = httpClient;
        this.mListener = mListener;
    }

    @Override
    protected Food doInBackground(String... params) {
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
