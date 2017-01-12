package com.example.exampicassotest.network;

import com.example.exampicassotest.model.LettersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by meltemyildirim on 1/11/17.
 */

public interface LetterApi {
    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<LettersResponse> getLettersResponse();
}
