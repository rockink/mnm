package com.mnm.rockink.recipe;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements InputImageFragment.InputImageFragmentInteraction {

    private FragmentManager fragmentManager;
    private InputImageFragment inputImageFragment;
    private ListFragment listFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(savedInstanceState!=null){
            inputImageFragment = (InputImageFragment) fragmentManager.findFragmentByTag("inputImageFragment");
            listFragment = (ListFragment) fragmentManager.findFragmentByTag("listFragment");
            if(inputImageFragment!=null){
                inputImageFragment.setParams(this);
                transaction.replace(R.id.framelayout,inputImageFragment);
            }
            else{
                inputImageFragment = new InputImageFragment();
                inputImageFragment.setParams(this);
            }
            if(listFragment != null){
                transaction.replace(R.id.framelayout,listFragment);
            }
            else{
                listFragment = new ListFragment();
            }
            transaction.commit();
        }
        else{

            inputImageFragment = new InputImageFragment();
            inputImageFragment.setParams(this);
            listFragment = new ListFragment();
            transaction.replace(R.id.framelayout,inputImageFragment,"inputImageFragment");
            transaction.commit();
        }



    }

    @Override
    public void imageChoosen(Bitmap b) {
        listFragment.setBitmap(b);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,listFragment,"listFragment");
        transaction.commit();
    }
}
