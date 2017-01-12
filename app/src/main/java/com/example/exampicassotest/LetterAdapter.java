package com.example.exampicassotest;

import android.content.Context;
import android.content.Intent;
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


    private static final String IMAGE_URL = "Image_Url";
    List<Letters> letterList;
    Context context;

    public LetterAdapter() {
        this.letterList = new ArrayList<>();
    }

    public LetterAdapter(List<Letters> letterList, Context context) {
        this.letterList = letterList;
        this.context = context;
    }


    @Override
    public LetterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_layout, parent, false);
        LetterViewHolder letterItem = new LetterViewHolder(itemView);
        return letterItem;
    }

    @Override
    public void onBindViewHolder(LetterViewHolder holder, int position) {

        final Letters letters = letterList.get(position);
        holder.setName(letters.getName());
        holder.setDetailImage(letters.getUrl());
        holder.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent letterIntent = new Intent(context, DetailActivity.class);
                letterIntent.putExtra(IMAGE_URL, letters.getUrl());
                context.startActivity(letterIntent);
            }
        });

    }

    public void setData(List<Letters> letterList) {
        this.letterList = letterList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return letterList.size();

    }
}
