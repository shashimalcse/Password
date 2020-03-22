package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ColorFour extends Fragment implements View.OnClickListener {
    private int Password_Size;
    private String Color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_four, container, false);
        Button blue = (Button) view.findViewById(R.id.color4_blue);
        blue.setOnClickListener(this);
        Button red = (Button) view.findViewById(R.id.color4_red);
        red.setOnClickListener(this);
        Button orange = (Button) view.findViewById(R.id.color4_orange);
        orange.setOnClickListener(this);
        Button purple = (Button) view.findViewById(R.id.color4_purple);
        purple.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ImageSelectionActivity.class);
        Password_Size=4;
        switch (v.getId()){
            case R.id.color4_blue:
                Color="Blue";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color4_red:
                Color="Red";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color4_orange:
                Color="Orange";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;
            case R.id.color4_purple:
                Color="Purple";
                intent.putExtra("PasswordSize",Integer.toString(Password_Size));
                intent.putExtra("Color",Color);
                startActivity(intent);
                break;


        }
    }
}
