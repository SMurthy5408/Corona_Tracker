package com.example.coronatracker;

import android.content.Context;

import android.content.res.AssetManager;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import com.google.gson.JsonObject;



/**
 * Requester class that sends a get request to the API
 */
public class RequestQueueService {
    private RequestQueue requestQueue;
    final String url = "https://api.covid19api.com/summary";
    private StringRequest stringRequest;
    private Context context;
    private JsonObject jsonObject;
    private TextView deaths;

    public RequestQueueService(Context ctx) {
        context = ctx;
        System.out.println("requester created");
    }

    /**
     * Connects to the api and sends a get request. Receives a string response that needs to be parsed to a JsonObject.
     * @return the Json Object received from the API
     */
    public void getData(final String country) {
        System.out.println("getData method invoked");
        requestQueue = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);

                CountryInfo countryInfo = new CountryInfo(convertedObject);
                countryInfo.extractInfo(country);

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

