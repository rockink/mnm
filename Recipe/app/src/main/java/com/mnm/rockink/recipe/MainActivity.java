package com.mnm.rockink.recipe;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mnm.rockink.recipe.dummy.DummyContent;
import com.mnm.rockink.recipe.jsonData.Food;

public class MainActivity extends AppCompatActivity implements AppDescriptionFragment.OnFragmentInteractionListener, URLForm.OnFragmentInteractionListener , RecipeList.OnListFragmentInteractionListener {

    private AppDescriptionFragment appDescriptionFragment;
    private URLForm urlFormFragment;
    private RecipeList recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        if(savedInstanceState != null){
            appDescriptionFragment = (AppDescriptionFragment) getSupportFragmentManager().findFragmentByTag("description");
            urlFormFragment = (URLForm) getSupportFragmentManager().findFragmentByTag("form");
            recipeList = (RecipeList) getSupportFragmentManager().findFragmentByTag("recipeList");

        }else {

            appDescriptionFragment = new AppDescriptionFragment();
            urlFormFragment = new URLForm();
            recipeList = new RecipeList();

            transaction.add(R.id.main_layout, appDescriptionFragment, "description");
            transaction.add(R.id.main_layout, urlFormFragment, "form");
            transaction.commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setFoodList(Food s) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

//        recipeList = new RecipeList();
        recipeList.setFoodData(s);

        transaction.remove(appDescriptionFragment);
        transaction.remove(urlFormFragment);
        transaction.add(R.id.main_layout, recipeList, "recipeList");
        transaction.commit();

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void startBrowser(String sourceUrl) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(sourceUrl));
        startActivity(i);
    }
}
