package com.mnm.rockink.buttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.usebutton.sdk.Button;
import com.usebutton.sdk.ButtonContext;
import com.usebutton.sdk.ButtonDropin;
import com.usebutton.sdk.context.Identifiers;
import com.usebutton.sdk.context.Location;
import com.usebutton.sdk.util.LocationProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        if (Button.getButton().getApplicationId().startsWith("app-0000")) {
            Toast.makeText(this,
                    "You need to customize the app ID in your AndroidManifest and the button ID in your layout XML.",
                    Toast.LENGTH_LONG).show();
        }


        ButtonDropin dropin = (ButtonDropin) findViewById(R.id.my_button);

        com.usebutton.sdk.context.Location location = new com.usebutton.sdk.context.Location("Wok Wok");
        location.putIdentifier(Identifiers.IDENTIFIER_DELIVERY_HERO, "1118");
        final ButtonContext context = ButtonContext.withSubjectLocation(location);



        dropin.prepareForDisplay(context, new ButtonDropin.Listener() {
            @Override
            public void onPrepared(final boolean isReady) {
            }

            @Override
            public void onClick(ButtonDropin buttonDropin) {

            }
        });



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

        dropin = (ButtonDropin) findViewById(R.id.my_button);
        location = new Location("New York");
        location.putIdentifier(Identifiers.IDENTIFIER_DELIVERY_HERO, "1118");


//        dropin.prepareForDisplay();


        dropin.prepareForDisplay(context, new ButtonDropin.Listener() {
            @Override
            public void onPrepared(final boolean isReady) {
                Toast.makeText(MainActivity.this,
                        String.format("Button %s.", isReady ? "available" : "unavailable"),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onClick(ButtonDropin buttonDropin) {

            }


        });

    }
}
