package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageGridActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Integer> FruitsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        gridView = (GridView) findViewById(R.id.gridview);

        ImageAdapter imageAdapter = new ImageAdapter(this,6);
        gridView.setAdapter(imageAdapter);
        FruitsArray = imageAdapter.getImageID();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(getApplicationContext(),getResources().getResourceEntryName(FruitsArray.get(position)),Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }
}
