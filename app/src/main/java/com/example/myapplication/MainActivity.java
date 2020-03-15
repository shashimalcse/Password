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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Color = intent.getStringExtra("Color");
        Password = intent.getStringExtra("Password");
        char[] Pass_Array = Password.toCharArray();
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

        for (int i=0;i<Pass_Array.length;i++){
            Numbers.get(i).setText(Character.toString(Pass_Array[i]));
        }


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
            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree-45;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree-=45;
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
