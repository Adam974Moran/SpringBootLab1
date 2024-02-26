package com.example.springbootlab1.business;

public class ErrorStatusCodeException extends Exception{
    private final String resultMessage;

    public ErrorStatusCodeException(int statusCode){
        if(statusCode < 400){
            this.resultMessage = "REDIRECTION: You need to take additional steps or contact another resource.";
        }
        else if(statusCode >= 500){
            this.resultMessage = "SERVER ERROR: This server cannot fulfill the request.";
        }
        else {
            this.resultMessage = "CLIENT ERROR: Incorrect parameters or can't be reached.";
        }
    }
    public String getResultMessage(){
        return resultMessage;
    }
}
