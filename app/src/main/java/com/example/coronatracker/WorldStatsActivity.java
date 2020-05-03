package com.example.coronatracker;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class WorldStatsActivity extends MainActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldstats);
        RequestQueueService requester = new RequestQueueService(getApplicationContext());

        // Country Info object to be created with name of button (the ocuntry name) passed into extractInfo method
        // of the country info class

        System.out.println("deaths for this country: ");
        //TextView deaths = findViewById(R.id.deaths);
        //String data = "";
        //deaths.setText(data);
    }
}
