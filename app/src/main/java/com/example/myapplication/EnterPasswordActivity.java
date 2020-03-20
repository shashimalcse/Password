package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;

public class EnterPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpassword);

        TextView size = (TextView) findViewById(R.id.password_size);
        TextView color = (TextView) findViewById(R.id.colorview);
        Pinview pin = (Pinview) findViewById(R.id.pinview1);


        Intent intent = getIntent();
        String PasswordSize = intent.getStringExtra("PasswordSize");
        String Color = intent.getStringExtra("Color");
        Log.d("s",PasswordSize);
        pin.setPinLength(Integer.parseInt(PasswordSize));
        if(Integer.parseInt(PasswordSize)==8){
            pin.setSplitWidth(10);
        }
        size.setText(PasswordSize);
        color.setText(Color);
    }
}
