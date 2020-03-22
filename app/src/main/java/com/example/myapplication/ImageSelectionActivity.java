package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageSelectionActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Integer> FruitsArray;
    ArrayList<Integer> SelectedPositions;
    Button Confirm;
    Button Remove;
    int Size;
    String SelectedColor;
    private String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        gridView = (GridView) findViewById(R.id.gridview);
        Confirm = (Button) findViewById(R.id.fruitsconfirmbtn);
        Remove = (Button) findViewById(R.id.fruitsremovebtn);
        Size=6;
        SelectedColor="blue";



        gridView.setNumColumns(Size/2);

        final ImageAdapter imageAdapter = new ImageAdapter(this,Size);
        gridView.setAdapter(imageAdapter);
        FruitsArray = imageAdapter.getImageID();

        SelectedPositions = new ArrayList<>();


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                try {
                    if(!SelectedPositions.contains(position)){
                        view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                        Log.d("s",Integer.toString(position));
                        SelectedPositions.add(position);

                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }



            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Password = "";
                int PasswordSize = SelectedPositions.size();
                for(int i=0;i<SelectedPositions.size();i++){

                    Password+=getResources().getResourceEntryName(FruitsArray.get(SelectedPositions.get(i)));

                }
                Log.d("s",Password);

                Intent intent = new Intent(ImageSelectionActivity.this,ImageConfirmationActivity.class);
                intent.putExtra("Size",Integer.toString(Size));
                intent.putExtra("SelectedColor",SelectedColor);
                intent.putExtra("Password",Password);
                intent.putExtra("PasswordSize",Integer.toString(PasswordSize));
                startActivity(intent);
            }
        });

        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SelectedPositions.size()>0) {
                    int end = SelectedPositions.size() - 1;
                    View view = gridView.getChildAt(SelectedPositions.get(SelectedPositions.size()-1));
                    SelectedPositions.remove(SelectedPositions.get(SelectedPositions.size() - 1));

                    Log.d("s", SelectedPositions.toString());


                    view.setBackgroundColor(Color.WHITE);

                    Log.d("s", SelectedPositions.toString());
                }

            }
        });

    }
}
