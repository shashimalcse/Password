package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ColorEight extends Fragment implements View.OnClickListener {
    private int Password_Size;
    private String Color;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_eight, container, false);

        Button blue = (Button) view.findViewById(R.id.color8_blue);
        blue.setOnClickListener(this);
        Button red = (Button) view.findViewById(R.id.color8_red);
        red.setOnClickListener(this);
        Button orange = (Button) view.findViewById(R.id.color8_orange);
        orange.setOnClickListener(this);
        Button purple = (Button) view.findViewById(R.id.color8_purple);
        purple.setOnClickListener(this);
        Button yellow = (Button) view.findViewById(R.id.color8_yellow);
        yellow.setOnClickListener(this);
        Button green = (Button) view.findViewById(R.id.color8_green);
        green.setOnClickListener(this);
        Button black = (Button) view.findViewById(R.id.color8_black);
        black.setOnClickListener(this);
        Button gray = (Button) view.findViewById(R.id.color8_gray);
        gray.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), EnterPasswordActivity.class);
        Password_Size=8;
        switch (v.getId()){
            case R.id.color8_blue:
                Color="Blue";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_red:
                Color="Red";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_orange:
                Color="Orange";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_purple:
                Color="Purple";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_green:
                Color="Green";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_yellow:
                Color="Yellow";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_black:
                Color="Black";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color8_gray:
                Color="Gray";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;

    }}
}
