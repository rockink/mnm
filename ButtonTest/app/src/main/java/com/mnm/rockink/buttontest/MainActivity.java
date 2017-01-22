package com.mnm.rockink.buttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.usebutton.sdk.Button;
import com.usebutton.sdk.ButtonContext;
import com.usebutton.sdk.ButtonDropin;
import com.usebutton.sdk.context.Identifiers;

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


        ButtonDropin dropin = (ButtonDropin) findViewById(R.id.main_dropin);

        final com.usebutton.sdk.context.Location location = new com.usebutton.sdk.context.Location("Wok Wok");
        location.putIdentifier(Identifiers.IDENTIFIER_DELIVERY_HERO, "1118");
        final ButtonContext context = ButtonContext.withSubjectLocation(location);

        dropin.prepareForDisplay(context, new ButtonDropin.Listener() {
            @Override
            public void onPrepared(final boolean isReady) {

                Toast.makeText(MainActivity.this, "Prepared to Listen " + isReady, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick(ButtonDropin buttonDropin) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
