package com.example.retrofitnotificationapi;

public class Results {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Results [error = " + error + "]";
    }
}
