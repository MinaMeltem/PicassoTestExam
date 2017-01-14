package com.example.exampicassotest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public class KeyResponse {

    @SerializedName("available keys")
    private List<KeyObj> availableKeys;
    private boolean success;


    public KeyResponse(List<KeyObj> availableKeys) {
        this.availableKeys = availableKeys;
    }

    public KeyResponse(boolean success, List<KeyObj> availableKeys) {
        this.success = success;
        this.availableKeys = availableKeys;
    }


    //getters
    public List<KeyObj> getAvailableKeys() {
        return availableKeys;
    }


    //setters

    public void setAvailableKeys(List<KeyObj> availableKeys) {
        this.availableKeys = availableKeys;
    }
}
