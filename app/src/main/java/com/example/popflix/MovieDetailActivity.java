package com.example.popflix;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView titleView, descView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        imageView = findViewById(R.id.detail_image);
        titleView = findViewById(R.id.detail_title);
        descView = findViewById(R.id.detail_description);

        if (getIntent() != null) {
            String title = getIntent().getStringExtra("title");
            String desc = getIntent().getStringExtra("description");
            int imageRes = getIntent().getIntExtra("imageResId", -1);

            titleView.setText(title);
            descView.setText(desc);
            if (imageRes != -1) imageView.setImageResource(imageRes);
        }
    }
}
