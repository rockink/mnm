package com.mnm.rockink.recipe;

import android.view.LayoutInflater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mnm.rockink.recipe.jsonData.Food;
import com.mnm.rockink.recipe.jsonData.Recipe;


public class RecipeRecyclerViewAdapter extends RecyclerView.Adapter<RecipeRecyclerViewAdapter.ViewHolder> {

    private final Food foodData;

    public RecipeRecyclerViewAdapter(Food foodData) {
        this.foodData = foodData;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


//        if (foodData == null) new GetItFromServer(httpClient, mListener).execute(urlString);

        holder.mItem = foodData.getRecipes().get(position);
        final Recipe recipe = holder.mItem;
        holder.titleView.setText(recipe.getTitle());
        holder.recipeView.setText(recipe.getSourceUrl());
        holder.nutritionalView.setText(recipe.getF2fUrl());

        holder.recipeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //mListener.startBrowser(recipe.getSourceUrl());
                //intent to explorer

            }
        });


        holder.nutritionalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mListener.startBrowser(recipe.getF2fUrl());
                //intent to explorer
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

