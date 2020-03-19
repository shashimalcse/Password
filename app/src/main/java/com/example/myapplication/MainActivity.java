package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView wheel;
    Button buttonLeft;
    Button buttonRight;
    Button Confirm;
    float oldDegree;
    float newDegree;
    private String Password;
    private String Color;
    private int Current;
    private int Color_Index;
    String Match_Pass;
    char[] Pass_Array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Color = intent.getStringExtra("Color");
        Password = intent.getStringExtra("Password");
        Pass_Array = Password.toCharArray();
        Pass_Array = RandomizeArray(Pass_Array);
        ArrayList<TextView> Numbers = new ArrayList<>();
        Numbers.add((TextView) findViewById(R.id.textView));
        Numbers.add((TextView) findViewById(R.id.textView2));
        Numbers.add((TextView) findViewById(R.id.textView3));
        Numbers.add((TextView) findViewById(R.id.textView4));
        Numbers.add((TextView) findViewById(R.id.textView5));
        Numbers.add((TextView) findViewById(R.id.textView6));
        Numbers.add((TextView) findViewById(R.id.textView7));
        Numbers.add((TextView) findViewById(R.id.textView8));


        ArrayList<String> Colors = new ArrayList<>();
        Colors.add("Purple");
        Colors.add("Red");
        Colors.add("Orange");
        Colors.add("Yellow");
        Colors.add("Green");
        Colors.add("Green_Blue");
        Colors.add("Blue");
        Colors.add("Dark_Blue");

        Color_Index = Colors.indexOf(Color)+1;

        Match_Pass = "";


        for (int i=0;i<Pass_Array.length;i++){
            Numbers.get(i).setText(Character.toString(Pass_Array[i]));
        }

        Current =0;
        wheel = (ImageView) findViewById(R.id.wheel);

        buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonRight = (Button) findViewById(R.id.buttonRight);
        Confirm = (Button) findViewById(R.id.button3);
        oldDegree = 0;
        newDegree = 0;


        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree+45;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree+=45;
                if(Color_Index>=7){
                    Color_Index=0;
                }
                else{
                    Color_Index++;
                }
                Log.d("s",Integer.toString(Color_Index));

            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree-45;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree-=45;
                if(Color_Index<=-7){
                    Color_Index=0;
                }
                else{
                    Color_Index--;
                }
                Log.d("s",Integer.toString(Color_Index));

            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Match_Pass.length()<Password.length()){
                    Match_Pass+=Pass_Array[Color_Index];
                    Log.d("a",Match_Pass);
                }
                else if(Match_Pass.equals(Password)){
                    Log.d("S","Succes");
                }
                else if(!Match_Pass.equals(Password)){
                    Log.d("S","NOt Succes");
                }

            }
        });


    }

    public void spin(float oldDegree,float newDegree){
        RotateAnimation rotateAnimation = new RotateAnimation(oldDegree,newDegree,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setDuration(100);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // we empty the result text view when the animation start

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // we display the correct sector pointed by the triangle at the end of the rotate animation

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheel.startAnimation(rotateAnimation);
    }
    public char[] RandomizeArray(char[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            char temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }


}
