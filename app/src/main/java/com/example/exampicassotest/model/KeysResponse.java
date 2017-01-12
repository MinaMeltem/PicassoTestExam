package com.example.exampicassotest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public class KeysResponse {

    private boolean success;
    @SerializedName("available keys")
    @Expose
    private List<Keys> availableKeys;


    public KeysResponse(List<Keys>availableKeys) {
        this.availableKeys = availableKeys;
    }

    public KeysResponse(boolean success, List<Keys> availableKeys) {
        this.success = success;
        this.availableKeys = availableKeys;
    }

    //getters

    public boolean isSuccess() {
        return success;
    }

    public List<Keys> getAvailableKeys() {
        return availableKeys;
    }

    //setters

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setAvailableKeys(List<Keys> availableKeys) {
        this.availableKeys = availableKeys;
    }
}
