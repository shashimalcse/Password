package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageGridActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Integer> FruitsArray;
    int nPrevSelGridItem;
    ArrayList<View> Selected;
    ArrayList<Integer> SelectedPositions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setNumColumns(3);

        final ImageAdapter imageAdapter = new ImageAdapter(this,6);
        gridView.setAdapter(imageAdapter);
        FruitsArray = imageAdapter.getImageID();

        nPrevSelGridItem=-1;


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View view1;
                Toast t = Toast.makeText(getApplicationContext(),getResources().getResourceEntryName(FruitsArray.get(position)),Toast.LENGTH_SHORT);
                t.show();


                try {
//                    if(nPrevSelGridItem!=-1){
//                        view1 = (View) gridView.getChildAt(nPrevSelGridItem);
//                        view1.setBackgroundColor(Color.WHITE);
//                    }
//                    nPrevSelGridItem = position;
//                    if (nPrevSelGridItem==position){


                    GradientDrawable border = new GradientDrawable();
                    border.setColor(Color.WHITE); //white background
                    border.setStroke(5, 0xFF000000);
//                        view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                        SelectedPositions.add(position);
                        view.setBackground(border);
//                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }



            }
        });

    }
}
