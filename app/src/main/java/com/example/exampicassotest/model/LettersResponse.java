package com.example.exampicassotest.model;

import java.util.List;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public class LettersResponse {
    private List<Letters> letterList;


    public LettersResponse(List<Letters> letterList) {
        this.letterList = letterList;
    }

    public List<Letters> getLetterList() {
        return letterList;
    }
}
