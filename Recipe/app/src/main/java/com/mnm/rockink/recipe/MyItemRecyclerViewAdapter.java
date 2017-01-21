package com.mnm.rockink.recipe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mnm.rockink.recipe.jsonData.Food;
import com.mnm.rockink.recipe.jsonData.Recipe;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final RecipeList.OnListFragmentInteractionListener mListener;
    private final Food foodData;

    public MyItemRecyclerViewAdapter(Food foodData, RecipeList.OnListFragmentInteractionListener mListener) {
        this.mListener = mListener;
        this.foodData = foodData;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        if(foodData == null) new GetItFromServer(httpClient, mListener).execute(urlString);


            holder.mItem = foodData.getRecipes().get(position);
        final Recipe recipe = holder.mItem;
        holder.titleView.setText(recipe.getTitle());
        holder.recipeView.setText(recipe.getSourceUrl());
        holder.nutritionalView.setText(recipe.getF2fUrl());

        holder.recipeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.startBrowser(recipe.getSourceUrl());

            }
        });


        holder.nutritionalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.startBrowser(recipe.getF2fUrl());
            }
        });


    }

    @Override
    public int getItemCount() {
        return foodData.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titleView;
        public final TextView recipeView;
        public final TextView nutritionalView;
        public Recipe mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleView = (TextView) view.findViewById(R.id.title);
            recipeView = (TextView) view.findViewById(R.id.recipe);
            nutritionalView = (TextView) view.findViewById(R.id.nutritional);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titleView.getText() + "'";
        }
    }
}
