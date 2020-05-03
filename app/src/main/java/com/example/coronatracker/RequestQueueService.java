package com.example.coronatracker;

import android.content.Context;

import android.content.res.AssetManager;
import android.util.Log;
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
    final String baseUrl = "https://api.covid19api.com/summary";
    private StringRequest stringRequest;
    private Context context;

    public RequestQueueService(Context ctx) {
        context = ctx;
    }

    /**
     * Connects to the api and sends a get request. Receives a string response that needs to be parsed to a JsonObject.
     * @return the Json Object received from the API
     */
    public JsonObject getData() {
        final JsonObject[] toReturn = new JsonObject[1];
        String url = baseUrl;
        requestQueue = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
                toReturn[0] = convertedObject;


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("That didn't work.");
            }
        });
        requestQueue.add(stringRequest);
        return toReturn[0];
    }
}

