package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordSizeActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_size);

        Button four = (Button) findViewById(R.id.colorfourbtn);
        Button six = (Button) findViewById(R.id.colorsixbtn);




        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                fragment = new ColorFour();
                ft.replace(R.id.frag,fragment);
                ft.commit();

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                fragment = new ColorSix();
                ft.replace(R.id.frag,fragment);
                ft.commit();

            }
        });
    }
}
