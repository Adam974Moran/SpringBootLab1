package com.example.springbootlab1.business;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonRemaster {
    private JsonRemaster(){}
    public static String gettingJsonKeyValues(String jsonResponse) throws JSONException {
        JSONObject jsonObject1 = new JSONObject(jsonResponse);
        JSONObject jsonObject12 = new JSONObject(jsonObject1.get("results").toString());
        JSONObject jsonObject2 = new JSONObject(jsonResponse);
        JSONObject jsonObject22 = new JSONObject(jsonObject2.get("results").toString());

        return "Sunrise: " + jsonObject12.get("sunrise") + ", sunset: " + jsonObject22.get("sunset");
    }
}
