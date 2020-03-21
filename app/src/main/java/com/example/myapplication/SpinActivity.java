package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class SpinActivity extends AppCompatActivity {

    ImageView ColorSpin;
    ImageView FruitSpin;
    Button SpinLeftBtn;
    Button SpinRightBtn;
    Button SpinConfirm;
    float oldDegree;
    float newDegree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        ColorSpin = (ImageView) findViewById(R.id.colorringfour);
        FruitSpin = (ImageView) findViewById(R.id.);
        SpinLeftBtn = (Button) findViewById(R.id.leftspinbtn);
        SpinRightBtn = (Button) findViewById(R.id.rightspinbtn);
        SpinConfirm = (Button) findViewById(R.id.spinconfirm);

        oldDegree = 0;
        newDegree = 0;

        ColorSpin.setImageDrawable(getResources().getDrawable(R.drawable.colorsix));

        SpinRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree+45;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree+=45;
//                if(Color_Index>=7){
//                    Color_Index=0;
//                }
//                else{
//                    Color_Index++;
//                }
//                Log.d("s",Integer.toString(Color_Index));

            }
        });

        SpinLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree-45;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree-=45;
//                if(Color_Index<=-7){
//                    Color_Index=0;
//                }
//                else{
//                    Color_Index--;
//                }
//                Log.d("s",Integer.toString(Color_Index));

            }
        });

        SpinConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(Match_Pass.length()<Password.length()){
//                    Match_Pass+=Pass_Array[Color_Index];
//                    Log.d("a",Match_Pass);
//                }
//                else if(Match_Pass.equals(Password)){
//                    Log.d("S","Succes");
//                }
//                else if(!Match_Pass.equals(Password)){
//                    Log.d("S","NOt Succes");
//                }

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

        Spin.startAnimation(rotateAnimation);
    }
}
