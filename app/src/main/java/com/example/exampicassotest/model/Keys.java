package com.example.exampicassotest.model;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public class Keys {

    private String name;
    private String textColor;
    private String url;

    public Keys() {
    }

    public Keys(String name, String textColor, String url) {
        this.name = name;
        this.textColor = textColor;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
