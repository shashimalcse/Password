package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;

public class PinUnlockActivity extends AppCompatActivity {
    private Pinview pin;
    private String Pin;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_unlock);

        pref = getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);

        TextView color = (TextView) findViewById(R.id.PinDescription);
        pin = (Pinview) findViewById(R.id.PinUnlock);

        Pin = pref.getString("Password",null);

        pin.setPinLength(4);


    }
}
