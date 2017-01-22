package com.mnm.rockink.recipe;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mnm.rockink.recipe.http.HttpClass;
import com.mnm.rockink.recipe.jsonData.Food;
import com.mnm.rockink.recipe.jsonData.Recipe;

import java.util.ArrayList;

public class ListFragment extends Fragment implements GetItFromServer.GetItemFromServerInterface {

    private Food recipes;
    private RecyclerView recyclerView;
    private RecipeRecyclerViewAdapter adapter;
    private Bitmap b;
    private RecyclerView.LayoutManager manager;

    static private HttpClass httpClient = new HttpClass();

    public ListFragment() {

    }


    public void setBitmap(Bitmap b){
        this.b = b;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment_layout, container, false);

        error("listfragment on creater");

        if(savedInstanceState!=null){
            recipes = savedInstanceState.getParcelable("food");
        }
        else{

            error("getting from server");
            new GetItFromServer(httpClient, this).execute(b);
        }

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        adapter = new RecipeRecyclerViewAdapter(recipes);
        recyclerView.setAdapter(adapter);
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);


        return v;
    }

    private void error(String s) {
        Log.d(getClass().getCanonicalName(), s);
    }

    @Override
    public void setFoodList(Food s) {
        recipes = s;
        adapter.setFoodList(s);
        adapter.notifyDataSetChanged();

//        adapter = new RecipeRecyclerViewAdapter(recipes);
//        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("food",recipes);
    }
}
