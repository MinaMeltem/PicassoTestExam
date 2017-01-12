package com.example.exampicassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.exampicassotest.model.Letters;
import com.example.exampicassotest.model.AvailableKeysResponse;
import com.example.exampicassotest.network.AvailableKeysApi;
import com.example.exampicassotest.network.AvailableKeysClient;

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

        AvailableKeysApi api = AvailableKeysClient.createService(AvailableKeysApi.class);
        Call<AvailableKeysResponse> call = api.getLettersResponse();

        call.enqueue(new Callback<AvailableKeysResponse>() {

            @Override
            public void onResponse(Call<AvailableKeysResponse> call, Response<AvailableKeysResponse> response) {
                AvailableKeysResponse lResponse = response.body();
                List<Letters> letterList = lResponse.getAvailableKeys();
                letterAdapter.setData(letterList);
            }

            @Override
            public void onFailure(Call<AvailableKeysResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
