package com.example.springbootlab1.business;

import org.springframework.http.ResponseEntity;

public class StatusCodeChecker {
    private StatusCodeChecker(){}

    public static void checkStatusCode(ResponseEntity<String> response) throws ErrorStatusCodeException{
        int statusCode = response.getStatusCode().value();
        if(statusCode >= 300){
            throw new ErrorStatusCodeException(statusCode);
        }
    }
}
