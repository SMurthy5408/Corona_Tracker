package com.example.coronatracker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WorldStatsActivity extends MainActivity {

    private RequestQueue requestQueue;
    final String url = "https://api.covid19api.com/summary";
    private StringRequest stringRequest;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldstats);
        //RequestQueueService requester = new RequestQueueService(getApplicationContext());
        getData("Global");
    }
    public void getData(final String country) {
        System.out.println("getData method invoked");
        requestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);

                CountryInfo countryInfo = new CountryInfo(convertedObject);
                countryInfo.extractInfo(country);
                TextView numDeaths = findViewById(R.id.deathNumbers);
                numDeaths.setText(countryInfo.getNumDeaths());
                TextView numRecovered = findViewById(R.id.recoveryNumbers);
                numRecovered.setText(countryInfo.getNumRecovered());
                TextView numCases = findViewById(R.id.casesNumbers);
                numCases.setText(countryInfo.getNumCases());



                //TextView may need to be done here for each country

                //deaths

                //deaths = findViewById(R.id.deathNumbers);
                //deaths.setText(countryInfo.getNumDeaths());

                // recovered

                // cases
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work.");
            }
        });
        requestQueue.add(stringRequest);
    }

}
