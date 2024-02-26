package com.example.springbootlab1.dataaccess;

import com.example.springbootlab1.business.ErrorStatusCodeException;
import com.example.springbootlab1.business.JsonRemaster;
import com.example.springbootlab1.business.StatusCodeChecker;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ResponseGetter {
    private ResponseGetter(){}

    public static String gettingFinalResponse(String url) throws JSONException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            StatusCodeChecker.checkStatusCode(response);
        }
        catch(ErrorStatusCodeException e){
            return e.getResultMessage();
        }

        String jsonResponse = response.getBody();

        return JsonRemaster.gettingJsonKeyValues(jsonResponse);
    }
}
