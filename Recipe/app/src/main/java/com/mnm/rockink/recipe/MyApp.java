package com.mnm.rockink.recipe;

import android.app.Application;

import com.usebutton.sdk.Button;


public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        Button.getButton(this).start();
        if (BuildConfig.DEBUG) {

            Button.enableDebugLogging();
        }


    }
}
