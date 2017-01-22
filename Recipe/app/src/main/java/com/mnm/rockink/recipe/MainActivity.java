package com.mnm.rockink.recipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.usebutton.sdk.Button;
import com.usebutton.sdk.ButtonContext;
import com.usebutton.sdk.ButtonDropin;
import com.usebutton.sdk.LineItem;
import com.usebutton.sdk.context.Location;
import com.usebutton.sdk.util.LocationProvider;

import java.util.Arrays;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements InputImageFragment.InputImageFragmentInteraction {

    private FragmentManager fragmentManager;
    private InputImageFragment inputImageFragment;
    private ListFragment listFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState!=null){
            inputImageFragment = (InputImageFragment) fragmentManager.findFragmentByTag("inputImageFragment");
            listFragment = (ListFragment) fragmentManager.findFragmentByTag("listFragment");
            FragmentTransaction transaction = fragmentManager.beginTransaction();
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
            FragmentTransaction transaction = fragmentManager.beginTransaction();
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
