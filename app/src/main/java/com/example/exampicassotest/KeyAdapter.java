package com.example.exampicassotest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exampicassotest.model.Keys;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by meltemyildirim on 1/11/17.
 */
public class KeyAdapter extends RecyclerView.Adapter<KeyViewHolder> {

    private static final String IMAGE_URL = "Image_Url";
    List<Keys> letterList;
    Context context;


    public KeyAdapter() {
        this.letterList = new ArrayList<>();
    }

    public KeyAdapter(List<Keys> letterList, Context context) {
        this.letterList = letterList;
        this.context = context;
    }


    @Override
    public KeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);
        KeyViewHolder letterItem = new KeyViewHolder(itemView);
        return letterItem;
    }

    @Override
    public void onBindViewHolder(KeyViewHolder holder, int position) {

        final Keys keys = letterList.get(position);
        holder.setName(keys.getName());
        holder.setDetailImage(keys.getUrl());
        holder.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent letterIntent = new Intent(context, DetailActivity.class);
                letterIntent.putExtra(IMAGE_URL, keys.getUrl());
                context.startActivity(letterIntent);
            }
        });

    }

    public void setData(List<Keys> letterList) {
        this.letterList = letterList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return letterList.size();

    }
}
