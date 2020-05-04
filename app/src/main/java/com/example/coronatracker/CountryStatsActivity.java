package com.example.coronatracker;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

public class CountryStatsActivity extends MainActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrystats);

        RequestQueueService requester = new RequestQueueService(getApplicationContext());

        // 1. create menu
        // 2. have a button for each menu item that corresponds to a country
        // 3. convert name of pressed button to string
        // 4. pass the string to getData method

        //name of button
        String country = "";

        requester.getData(country);
    }
}