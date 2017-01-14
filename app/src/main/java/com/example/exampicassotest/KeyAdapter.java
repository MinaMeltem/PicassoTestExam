package com.example.exampicassotest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exampicassotest.model.KeyObj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meltemyildirim on 1/13/17.
 */

public class KeyAdapter extends RecyclerView.Adapter <KeyViewHolder> {

    private List <KeyObj> keyObjList;
    private KeyFragment keyFragment;


    public KeyAdapter() {
        this.keyObjList = new ArrayList<>();

    }

    public KeyAdapter(List<KeyObj> keyObjList, KeyFragment keyFragment) {
        this.keyObjList = new ArrayList<>();
        this.keyFragment = keyFragment;
    }

    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);
        KeyViewHolder singleKeyView = new KeyViewHolder(itemView);

        return singleKeyView;
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {
        KeyObj keyObj = keyObjList.get(position);
        holder.bind(keyObj);

    }

    public void setData(List <KeyObj> keyObjList){
        this.keyObjList = keyObjList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return keyObjList.size();
    }
}
