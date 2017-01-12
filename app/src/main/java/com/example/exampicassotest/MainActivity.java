package com.example.exampicassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.exampicassotest.model.Letters;
import com.example.exampicassotest.model.LettersResponse;
import com.example.exampicassotest.network.LetterApi;
import com.example.exampicassotest.network.LetterClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LetterAdapter letterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letterAdapter = new LetterAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(letterAdapter);

        LetterApi api = LetterClient.createService(LetterApi.class);
        Call<LettersResponse> call = api.getLettersResponse();

        call.enqueue(new Callback<LettersResponse>() {

            @Override
            public void onResponse(Call<LettersResponse> call, Response<LettersResponse> response) {
                LettersResponse lResponse = response.body();
                List<Letters> letterList = lResponse.getLetterList();
                letterAdapter.setData(letterList);
            }

            @Override
            public void onFailure(Call<LettersResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
