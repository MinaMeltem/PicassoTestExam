package com.example.exampicassotest;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.exampicassotest.model.KeyObj;

/**
 * Created by meltemyildirim on 1/13/17.
 */

public class KeyViewHolder extends RecyclerView.ViewHolder {

    private TextView keyLetterTV;

    public KeyViewHolder(View itemView) {
        super(itemView);
        keyLetterTV = (TextView) itemView.findViewById(R.id.letters_name_tv);
    }

    public void bind(final KeyObj letter) {
        keyLetterTV.setText(letter.getName());
        keyLetterTV.setTextColor(Color.parseColor(letter.getTextColor()));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ImageActivity.class);
                intent.putExtra(ImageActivity.KEY_IMAGE_URL, letter.getUrl());
                view.getContext().startActivity(intent);
            }
        });
    }
}