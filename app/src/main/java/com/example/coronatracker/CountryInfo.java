package com.example.coronatracker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Set;

public class CountryInfo {
    JsonObject info;
    private String numDeaths;
    private String numRecovered;
    private String numCases;
    private HashMap<String, JsonObject> mapOfCountries;
    private JsonArray countries;
    public CountryInfo(JsonObject response) {
        info = response;
        countries = info.get("Countries").getAsJsonArray();
        mapOfCountries = new HashMap<>();
        System.out.println("country info object has been created.");
        for (JsonElement c : countries) {
            JsonObject cObj = c.getAsJsonObject();
            String countryName = cObj.get("Country").getAsString();
            mapOfCountries.put(countryName, cObj);
        }
        System.out.println("hash map created");
    }

    /**
     * Extracts essential country info from the Json response
     * @param country the name of the country analyzed
     */
    public void extractInfo(String country) {
        JsonObject ctObj = null;
        System.out.println("extracting info from object");
        if (mapOfCountries.containsKey(country)) {
            System.out.println("found country!");
            ctObj = mapOfCountries.get(country);
        } else if (country.equals("Global")) {
            ctObj = info.get("Global").getAsJsonObject();
        }
        System.out.println("ctObj is null: " + ctObj.isJsonNull());
        JsonElement deaths = ctObj.get("TotalDeaths");
        numDeaths = deaths.getAsString();
        System.out.println("num of deaths: " + getNumDeaths());
        JsonElement recovered = ctObj.get("TotalRecovered");
        numRecovered = recovered.getAsString();
        System.out.println("num recovered: " + getNumRecovered());
        JsonElement cases = ctObj.get("TotalConfirmed");
        numCases = cases.getAsString();
        System.out.println("num cases: " + getNumCases());
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