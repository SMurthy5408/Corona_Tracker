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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RequestQueueService {
    private RequestQueue requestQueue;
    final String baseUrl = "https://api.covid19api.com/";
    private StringRequest stringRequest;
    private Context context;

    public RequestQueueService(Context ctx) {
        context = ctx;
    }

    public String getData(String endpt) {
        final String[] result = {""};
        String url = baseUrl + endpt;
        requestQueue = Volley.newRequestQueue(context);
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                System.out.println(response.substring(0,10));
                result[0] += response.substring(0,10);
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

