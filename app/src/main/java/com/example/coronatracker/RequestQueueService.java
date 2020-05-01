package com.example.coronatracker;

import android.content.Context;

import android.content.res.AssetManager;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Requester class that sends a get request to the API
 */
public class RequestQueueService {
    private RequestQueue requestQueue;
    final String baseUrl = "https://api.covid19api.com/";
    private StringRequest stringRequest;
    private Context context;

    public RequestQueueService(Context ctx) {
        context = ctx;
    }

    /**
     * Connects to the api and sends a get request. Receives a string response that needs to be parsed to a JsonObject.
     * @param endpt the url endpoint that comes after the base URL
     * @param country can be either "Global" or the country name like "China"
     * @return the parsed String with the data needed
     */
    public String getData(String endpt, final String country) {
        final String[] result = {""};
        String url = baseUrl + endpt;
        requestQueue = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response.substring(0,10));
                JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
                CountryInfo info = new CountryInfo(convertedObject);
                info.extractInfo(country);
                result[0] += info.getNumCases();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work.");
            }
        });
        requestQueue.add(stringRequest);
        return result[0];
    }
}

