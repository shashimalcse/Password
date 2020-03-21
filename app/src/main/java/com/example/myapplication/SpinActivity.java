package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinActivity extends AppCompatActivity {

    ImageView ColorSpin;
    ImageView FruitSpin;
    Button SpinLeftBtn;
    Button SpinRightBtn;
    Button SpinConfirm;
    float oldDegree;
    float newDegree;
    int Size;
    Spin spin;
    int Degree;
    private String UserColor;
    ArrayList<String> ColorsArray;
    ArrayList<String> FruitsArray;
    private int Color_Index;
    int PhaseChange;
    private String UserPassword;
    private String MatchingPassword;
    int SelectedFruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);
        ColorSpin = (ImageView) findViewById(R.id.colorspin);
        FruitSpin = (ImageView) findViewById(R.id.fruitspin);
        SpinLeftBtn = (Button) findViewById(R.id.leftspinbtn);
        SpinRightBtn = (Button) findViewById(R.id.rightspinbtn);
        SpinConfirm = (Button) findViewById(R.id.spinconfirm);

        oldDegree = 0;
        newDegree = 0;


        Size=6;
        UserColor="red";
        UserPassword="orangeapplecherry";
        MatchingPassword="";
        SelectedFruits=0;




        if(Size==4){
            spin = new SpinFour();
        }
        else if(Size==6){
            spin = new SpinSix();
        }
        else {
            spin = new SpinEight();
        }


        ColorSpin.setImageDrawable(getResources().getDrawable(spin.getColorRing()));
        FruitSpin.setImageDrawable(getResources().getDrawable(spin.getFruitRing()));
        Degree = spin.getDegree();
        ColorsArray = spin.getColors();
        FruitsArray = spin.getFruits();
        PhaseChange = spin.getPhaseChange();


        Color_Index = ColorsArray.indexOf(UserColor);




        SpinRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree+Degree;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree+=Degree;
                if(Color_Index>=PhaseChange){
                    Color_Index=0;
                }
                else{
                    Color_Index++;
                }
                Log.d("s",Integer.toString(Color_Index));

            }
        });

        SpinLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float d = newDegree-Degree;
                spin(oldDegree,d);
                oldDegree=d;
                newDegree-=Degree;
                if(Color_Index<=-PhaseChange){
                    Color_Index=0;
                }
                else{
                    Color_Index--;
                }
                Log.d("s",Integer.toString(Color_Index));

            }
        });

        SpinConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectedFruits++;
                MatchingPassword+=FruitsArray.get(Color_Index);
                if(MatchingPassword.equals(UserPassword)){
                    Toast  t = Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT);
                    t.show();
                }

                else if (!MatchingPassword.equals(UserPassword) && SelectedFruits==FruitsArray.size()){
                    Toast  t = Toast.makeText(getApplicationContext(),"WRONG",Toast.LENGTH_SHORT);
                    t.show();
                    SelectedFruits=0;
                }

                Log.d("FRUIT",FruitsArray.get(Color_Index));

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

        ColorSpin.startAnimation(rotateAnimation);
    }
}
