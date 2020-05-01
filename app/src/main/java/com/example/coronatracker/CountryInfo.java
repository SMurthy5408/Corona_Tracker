package com.example.coronatracker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CountryInfo {
    JsonObject info;
    private String numDeaths;
    private String numRecovered;
    private String numCases;
    public CountryInfo(JsonObject response) {
        info = response;
    }

    public void extractInfo(String country) {
        JsonArray array = info.get(country).getAsJsonArray();
        JsonElement deaths = array.getAsJsonObject().get("TotalDeaths");
        numDeaths = deaths.getAsString();
        JsonElement recovered = array.getAsJsonObject().get("TotalRecovered");
        numRecovered = recovered.getAsString();
        JsonElement cases = array.getAsJsonObject().get("TotalCases");
        numCases = cases.getAsString();
    }

    public String getNumCases() {
        return numCases;
    }

    public String getNumDeaths() {
        return numDeaths;
    }

    public String getNumRecovered() {
        return numRecovered;
    }
}
