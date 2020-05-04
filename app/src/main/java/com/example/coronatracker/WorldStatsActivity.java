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
        requester.getData("Global");

        /*
        TableLayout table = findViewById(R.id.table);
        TextView deathsTitle = findViewById(R.id.deathsTitle);
        TextView recoveriesTitle = findViewById(R.id.recoveriesTitle);
        TextView casesTitle = findViewById(R.id.casesTitle);
*/

    }
}
