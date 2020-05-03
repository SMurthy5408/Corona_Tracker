package com.example.coronatracker;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WorldStatsActivity extends MainActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldstats);
        RequestQueueService requester = new RequestQueueService(getApplicationContext());

        // Country Info object to be created with name of button (the country name) passed into extractInfo method
        // of the country info class
        JsonObject bigJson = requester.getData();
        //JsonObject bigJson = bigElement.getAsJsonObject();

        // Looks like BigJson is null. Right now, it builds a table that has the three categories
        // and 0, 0, 0 under each category.
        if (bigJson == null) {
            System.out.println("bigJson is null");
        }
        JsonObject worldJson = bigJson.get("Global").getAsJsonObject();
        String totalConfirmed = worldJson.get("TotalConfirmed").getAsString();
        String totalDeaths = worldJson.get("TotalDeaths").getAsString();



        System.out.println("cases for this country: " + totalConfirmed);
        TableLayout table = findViewById(R.id.table);
        TextView deathsTitle = findViewById(R.id.deathsTitle);
        TextView recoveriesTitle = findViewById(R.id.recoveriesTitle);
        TextView casesTitle = findViewById(R.id.casesTitle);
        TextView deaths = findViewById(R.id.deathNumbers);
        deaths.setText(totalDeaths);
    }
}
