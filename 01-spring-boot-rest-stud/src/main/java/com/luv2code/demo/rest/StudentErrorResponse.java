package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int Status;
    private String message;
    private long timeStamps;

    public StudentErrorResponse(int status, String message, long timeStamps) {
        Status = status;
        this.message = message;
        this.timeStamps = timeStamps;
    }

    public StudentErrorResponse() {

    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        message="bad request";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(long timeStamps) {
        this.timeStamps = timeStamps;
    }
}
