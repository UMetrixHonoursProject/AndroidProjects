package com.example.ramya.helloapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class SecondActivity extends Activity {
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_screen);
        b1 = (Button) findViewById(R.id.button2);

        TourGuide mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())
                .setToolTip(new ToolTip().setTitle("Tap here to view savings account summary!"))
                .setOverlay(new Overlay())
                .playOn(b1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {

                // Start NewActivity.class
                Intent myIntent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(myIntent);
            }
        });
    }

}