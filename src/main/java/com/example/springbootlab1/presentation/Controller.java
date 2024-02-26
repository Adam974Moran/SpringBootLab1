package com.example.springbootlab1.presentation;

import com.example.springbootlab1.business.WrongFormatException;
import com.example.springbootlab1.dataaccess.ResponseGetter;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/sunrise")
    public String tellSunriseTime(@RequestParam(value = "lat", defaultValue = "null") String lat,
                                  @RequestParam(value = "lng", defaultValue = "null") String lng,
                                  @RequestParam(value = "date", defaultValue = "null") String date,
                                  @RequestParam(value = "formatted", defaultValue = "null") String formatted) throws JSONException {
        String url;
        try {
            url = UrlChecker.checkUrl(lat, lng, date, formatted);
        }
        catch (WrongFormatException w){
            return w.getExceptionMessage();
        }

        return ResponseGetter.gettingFinalResponse(url);
    }
}
