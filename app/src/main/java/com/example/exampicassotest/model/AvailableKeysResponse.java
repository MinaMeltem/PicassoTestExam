package com.example.exampicassotest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public class AvailableKeysResponse {

    private boolean success;
    @SerializedName("available keys")
    @Expose
    private List<Letters> availableKeys;


    public AvailableKeysResponse(List<Letters>availableKeys) {
        this.availableKeys = availableKeys;
    }

    public AvailableKeysResponse(boolean success, List<Letters> availableKeys) {
        this.success = success;
        this.availableKeys = availableKeys;
    }

    //getters

    public boolean isSuccess() {
        return success;
    }

    public List<Letters> getAvailableKeys() {
        return availableKeys;
    }

    //setters

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setAvailableKeys(List<Letters> availableKeys) {
        this.availableKeys = availableKeys;
    }
}
