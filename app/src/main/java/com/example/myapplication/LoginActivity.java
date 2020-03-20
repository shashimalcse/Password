package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView size = (TextView) findViewById(R.id.password_size);
        TextView color = (TextView) findViewById(R.id.colorview);

        Intent intent = getIntent();
        String PasswordSize = intent.getStringExtra("PasswordSize");
        String Color = intent.getStringExtra("Color");
        Log.d("s",PasswordSize);

        size.setText(PasswordSize);
        color.setText(Color);
    }
}
