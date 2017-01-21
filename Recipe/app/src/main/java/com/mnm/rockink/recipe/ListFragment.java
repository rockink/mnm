package com.mnm.rockink.recipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mnm.rockink.recipe.jsonData.Recipe;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ArrayList<Recipe> recipes;

    public void setList(ArrayList<Recipe> list){
        recipes = list;
    }

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_fragment_layout, container, false);
        return v;
    }

}
