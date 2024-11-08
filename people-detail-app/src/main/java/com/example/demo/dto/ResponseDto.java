package com.example.demo.dto;

public class ResponseDto {
    String statusMessage;
    int statusCode;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }


}
