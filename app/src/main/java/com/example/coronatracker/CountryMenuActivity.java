package com.example.coronatracker;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CountryMenuActivity extends MainActivity {
    private ListView listView;
    private ArrayAdapter adapter;
    private String country;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_menu);
        listView = findViewById(R.id.menu);
        adapter = ArrayAdapter.createFromResource(this, R.array.countries_array, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                country = adapter.getItemAtPosition(position).toString();
                System.out.println(country);
                Intent intent = new Intent(CountryMenuActivity.this, CountryStatsActivity.class);
                intent.putExtra("countryName", country);
                startActivity(intent);

            }
        });

        //RequestQueueService requester = new RequestQueueService(getApplicationContext());

        // 1. create menu
        // 2. have a button for each menu item that corresponds to a country
        // 3. convert name of pressed button to string
        // 4. pass the string to getData method
        //requester.getData(country);
    }

}