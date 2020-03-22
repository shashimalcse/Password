package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ImageConfirmationActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Integer> FruitsArray;
    ArrayList<Integer> SelectedPositions;
    Button Confirm;
    Button Remove;
    int Size;
    String SelectedColor;
    private String SelectedPassword;
    int SelectedPasswordSize;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_confirmation);
        gridView = (GridView) findViewById(R.id.gridview2);
        Confirm = (Button) findViewById(R.id.fruitsconfirmbtn2);
        Remove = (Button) findViewById(R.id.fruitsremovebtn2);

        pref = getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);
        editor =pref.edit();

        Intent i =getIntent();
        Size=Integer.parseInt(i.getStringExtra("Size"));
        SelectedColor=i.getStringExtra("SelectedColor");
        SelectedPasswordSize=Integer.parseInt(i.getStringExtra("PasswordSize"));
        SelectedPassword=i.getStringExtra("Password");


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
                if(PasswordSize==SelectedPasswordSize && Password.equals(SelectedPassword)){

                    editor.putString("GraphicalPassword",SelectedPassword);
                    editor.putString("GraphicalPasswordSize",Integer.toString(PasswordSize));
                    editor.apply();

                    Toast t = Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT);
                    t.show();
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(),"Not Match",Toast.LENGTH_SHORT);
                    t.show();
                    Password="";
                }
//                Intent intent = new Intent(ImageConfirmationActivity.this,SuccessActivity.class);
//                startActivity(intent);
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
