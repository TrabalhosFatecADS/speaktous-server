package com.speakToUs.model;

public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;
    private String token;

    public ApiResponse(int status, String message, Object result, String token) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
