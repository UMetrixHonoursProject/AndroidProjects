package com.example.ramya.helloapplication;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

import tourguide.tourguide.Overlay;
import tourguide.tourguide.Pointer;
import tourguide.tourguide.ToolTip;
import tourguide.tourguide.TourGuide;

public class ThirdActivity extends Activity {
    Button b2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.third_screen);
        b2 = (Button) findViewById(R.id.button3);
        TourGuide mTourGuideHandler = TourGuide.init(this).with(TourGuide.Technique.Click)
                .setPointer(new Pointer())
                .setToolTip(new ToolTip().setTitle("Click to export your statement in PDF format"))
                .setOverlay(new Overlay())
                .playOn(b2);
    }
}