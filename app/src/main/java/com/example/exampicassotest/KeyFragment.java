package com.example.exampicassotest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.exampicassotest.model.KeyObj;
import com.example.exampicassotest.model.KeyResponse;
import com.example.exampicassotest.network.KeyApi;
import com.example.exampicassotest.network.KeyClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by meltemyildirim on 1/13/17.
 */
public class KeyFragment extends Fragment{
    FrameLayout rootLayout;
    RecyclerView keyRecView;
    KeyAdapter keyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_layout, container, false);
        keyRecView = (RecyclerView)v.findViewById(R.id.recycler_view);
        rootLayout = (FrameLayout)v.findViewById(R.id.rcyc_container_fragment);
        keyAdapter = new KeyAdapter();//???
        keyRecView.setAdapter(keyAdapter);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        KeyApi keyApi = KeyClient.createService(KeyApi.class);
        Call<KeyResponse> call = keyApi.getKeyResponse();

        call.enqueue(new Callback<KeyResponse>() {
            @Override
            public void onResponse(Call<KeyResponse> call, Response<KeyResponse> response) {
                KeyResponse keyResponse = response.body();
                List <KeyObj> keyObjList = keyResponse.getAvailableKeys();
                keyAdapter.setData(keyObjList);
            }

            @Override
            public void onFailure(Call<KeyResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Unable to connect to internet", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
