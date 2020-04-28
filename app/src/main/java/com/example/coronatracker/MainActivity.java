package com.example.coronatracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.appBar);
        setSupportActionBar(myToolbar);
        Button countryButton = findViewById(R.id.selectCountry);
        Button worldButton = findViewById(R.id.selectWorld);
        Log.i("Creation", "I've been created.");
        final Intent countryIntent = new Intent(this, CountryStatsActivity.class);
        final Intent worldIntent = new Intent(this, WorldStatsActivity.class);

        countryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Country");
                startActivity(countryIntent);
            }
        });


        worldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("World");
                startActivity(worldIntent);
            }
        });
    }

}
