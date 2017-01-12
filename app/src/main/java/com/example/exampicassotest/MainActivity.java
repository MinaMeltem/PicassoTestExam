package com.example.exampicassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.exampicassotest.model.Keys;
import com.example.exampicassotest.model.KeysResponse;
import com.example.exampicassotest.network.AvailableKeysApi;
import com.example.exampicassotest.network.AvailableKeysClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    KeyAdapter keyAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            keyAdapter = new KeyAdapter();
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setAdapter(keyAdapter);

            AvailableKeysApi api = AvailableKeysClient.createService(AvailableKeysApi.class);
            Call<KeysResponse> call = api.getKeysResponse();


            call.enqueue(new Callback<KeysResponse>() {
                @Override
                public void onResponse(Call<KeysResponse> call, Response<KeysResponse> response) {
                    KeysResponse keyResponse = response.body();
                    List<Keys> keyList = keyResponse.getAvailableKeys();
                    keyAdapter.setData(keyList);
                }

                @Override
                public void onFailure(Call<KeysResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
