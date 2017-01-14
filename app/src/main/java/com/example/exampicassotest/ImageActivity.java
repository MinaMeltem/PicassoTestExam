package com.example.exampicassotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by meltemyildirim on 1/13/17.
 */

public class ImageActivity extends AppCompatActivity {

    private static final String TAG = ImageActivity.class.getSimpleName();

    private ImageView imageView;
    private boolean clickedOnce;
    private static String IMAGE_BASE_URL = "http://jsjrobotics.nyc/";
    public static  final String KEY_IMAGE_URL = "IMAGE_URL";

    public static final String KEY_CLICKED_ONCE = "CLICKED_ONCE";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        imageView = (ImageView) findViewById(R.id.detail_image_iv);
        Intent intent = getIntent();


        if (!intent.getStringExtra(KEY_IMAGE_URL).isEmpty()) {
            Picasso.with(getApplicationContext())
                    .load(IMAGE_BASE_URL + intent.getExtras().getString(KEY_IMAGE_URL))
                    .into(imageView);
        } else {
            Toast.makeText(this, "No image to display",
                    Toast.LENGTH_LONG).show();
        }

        if (savedInstanceState != null) {
            clickedOnce = savedInstanceState.getBoolean(KEY_CLICKED_ONCE);
        }

//        Log.d(TAG, "is savedInstance state is null? " + String.valueOf(savedInstanceState  == null));
//        Log.d(TAG, "is clicked once true? " + clickedOnce);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_CLICKED_ONCE, clickedOnce );

    }

    @Override
    public void onBackPressed() {
        if (clickedOnce) {
            clickedOnce = false;
            super.onBackPressed();
        } else {
            clickedOnce = true;
            Toast.makeText(this, "Press once more to see list", Toast.LENGTH_SHORT).show();
        }
    }
}
