package com.mnm.rockink.recipe;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecipeListActivity extends AppCompatActivity {

    private RecipeList recipeList;
    private Intent intent;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        if(savedInstanceState != null){

            recipeList = (RecipeList) getSupportFragmentManager().findFragmentByTag("recipeList");
            url = savedInstanceState.getString("url");
            recipeList.startHttpRequest(url);


        }else {

            intent = getIntent();
            url = intent.getStringExtra("url");

            recipeList = new RecipeList();
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.framelayout, recipeList, "description");
            transaction.commit();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("url", url);
    }
}
