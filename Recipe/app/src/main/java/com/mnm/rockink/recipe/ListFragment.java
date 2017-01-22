package com.mnm.rockink.recipe;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mnm.rockink.recipe.jsonData.Food;
import com.mnm.rockink.recipe.jsonData.Recipe;

import java.util.ArrayList;

public class ListFragment extends Fragment implements GetItFromServer.GetItemFromServerInterface {

    private Food recipes;
    private RecyclerView recyclerView;
    private RecipeRecyclerViewAdapter adapter;
    private Bitmap b;

    public ListFragment() {

    }

    public void setBitmap(Bitmap b){
        this.b = b;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment_layout, container, false);

        if(savedInstanceState!=null){
            recipes = savedInstanceState.getParcelable("food");
        }
        else{
            //recipes = GetItFromServer bitmap b
        }

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        adapter = new RecipeRecyclerViewAdapter(recipes);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void setFoodList(Food s) {
        recipes = s;
        adapter = new RecipeRecyclerViewAdapter(recipes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("food",recipes);
    }
}
