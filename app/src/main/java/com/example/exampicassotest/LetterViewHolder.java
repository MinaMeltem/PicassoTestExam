package com.example.exampicassotest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by meltemyildirim on 1/11/17.
 */
public class LetterViewHolder extends RecyclerView.ViewHolder {

    TextView letterName;
    ImageView detailImage;

    public LetterViewHolder(View itemView) {
        super(itemView);

        letterName = (TextView) itemView.findViewById(R.id.letters_name_tv);
        detailImage = (ImageView) itemView.findViewById(R.id.detail_image_iv);

    }

    public void setOnclickListener(View.OnClickListener listener) {
        letterName.setOnClickListener(listener);

    }

    public void setName(String name) {
        letterName.setText(name);
    }

    public void setDetailImage(String url) {
        Picasso.with(detailImage.getContext()).load(url).into(detailImage);
    }

}
