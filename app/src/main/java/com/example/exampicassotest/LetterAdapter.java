package com.example.exampicassotest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exampicassotest.model.Letters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meltemyildirim on 1/11/17.
 */
public class LetterAdapter extends RecyclerView.Adapter<LetterViewHolder> {


    List <Letters> letterList;

    public LetterAdapter() {
        this.letterList = new ArrayList<>();
    }

    public LetterAdapter(List<Letters> letterList) {
        this.letterList = letterList;
    }


    @Override
    public LetterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);
        LetterViewHolder albumItem = new LetterViewHolder(itemView);
        return albumItem;
    }

    @Override
    public void onBindViewHolder(LetterViewHolder holder, int position) {

        Letters letters = letterList.get(position);
        holder.setName(letters.getName());
        holder.setDetailImage(letters.getUrl());

    }

    @Override
    public int getItemCount() {
        return letterList.size();
    }
}
