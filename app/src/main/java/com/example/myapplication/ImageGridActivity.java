package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageGridActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        gridView = (GridView) findViewById(R.id.gridview);

        ImageAdapter imageAdapter = new ImageAdapter(this,8);
        gridView.setAdapter(imageAdapter);

    }
}
