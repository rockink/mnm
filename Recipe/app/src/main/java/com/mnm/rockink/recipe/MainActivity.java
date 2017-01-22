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


    private View.OnClickListener mOnBuy = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            EditText amountView = (EditText) findViewById(R.id.main_amount);
            final Context context = v.getContext();
            if (TextUtils.isEmpty(amountView.getText())) {
                Toast.makeText(context, "Please enter an amount first.", Toast.LENGTH_SHORT).show();
                return;
            }
            // Since we don't have any order backend setup in our sample app, let's create an order ID locally
            final String orderId = UUID.randomUUID().toString();
            final int valuePennies = Integer.parseInt(amountView.getText().toString()) * 100;
            final LineItem line = new LineItem("test-product", valuePennies);
            Button.getButton(context).reportOrder(Arrays.asList(line), "USD", orderId);

            Toast.makeText(context,
                    String.format("Attributed order of $%.2f", valuePennies / 100.0),
                    Toast.LENGTH_LONG).show();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        if (Button.getButton().getApplicationId().startsWith("app-0000")) {
            Toast.makeText(this,
                    "You need to customize the app ID in your AndroidManifest and the button ID in your layout XML.",
                    Toast.LENGTH_LONG).show();
        }

        // Let's register our user ID so we can correlate our users with Button's data
        Button.getButton(this).setUserIdentifier("myuser@usebutton.com");

        // Get the Button View
        final ButtonDropin buttonDropin = (ButtonDropin) findViewById(R.id.main_dropin);

        // Create a PlacementContext for the location you want a ride to.
        final Location officeLocation = new Location("Button HQ", 40.732561, -73.988068);
        final ButtonContext context = ButtonContext.withSubjectLocation(officeLocation);

        //noinspection ResourceType
        final android.location.Location bestLocation = new LocationProvider(this).getBestLocation();
        if (bestLocation != null) {
            context.setUserLocation(new Location(bestLocation));
        }
        else {
            // Just to make sure we work on emulator etc, we'll use another place in NYC
            // comment out to use your current location from above
            context.setUserLocation(new Location(40.732561, -73.988068));
        }

        // Prepare the Button for display with our context
        buttonDropin.prepareForDisplay(context, new ButtonDropin.Listener() {
            @Override
            public void onPrepared(final boolean willDisplay) {
                // Toggle visibility of UI items here if necessary
                Toast.makeText(MainActivity.this,
                        String.format("Button %s.", willDisplay ? "available" : "unavailable"),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClick(final ButtonDropin buttonDropin) {}
        });

        // Let's setup our order attribution
        final ImageButton buyButton = (ImageButton) findViewById(R.id.main_buy);
        buyButton.setOnClickListener(mOnBuy);




//        fragmentManager = getSupportFragmentManager();
//
//        if(savedInstanceState!=null){
//            inputImageFragment = (InputImageFragment) fragmentManager.findFragmentByTag("inputImageFragment");
//            listFragment = (ListFragment) fragmentManager.findFragmentByTag("listFragment");
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            if(inputImageFragment!=null){
//                inputImageFragment.setParams(this);
//                transaction.replace(R.id.framelayout,inputImageFragment);
//            }
//            else{
//                inputImageFragment = new InputImageFragment();
//                inputImageFragment.setParams(this);
//            }
//            if(listFragment != null){
//                transaction.replace(R.id.framelayout,listFragment);
//            }
//            else{
//                listFragment = new ListFragment();
//            }
//            transaction.commit();
//        }
//        else{
//            inputImageFragment = new InputImageFragment();
//            inputImageFragment.setParams(this);
//            listFragment = new ListFragment();
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//            transaction.replace(R.id.framelayout,inputImageFragment,"inputImageFragment");
//            transaction.commit();
//        }

    }

    @Override
    public void imageChoosen(Bitmap b) {
        listFragment.setBitmap(b);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,listFragment,"listFragment");
        transaction.commit();
    }
}
