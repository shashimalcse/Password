package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.goodiebag.pinview.Pinview;

public class EnterPasswordActivity extends AppCompatActivity {
    private String PasswordSize;
    private String Color;
    private Pinview pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpassword);


        TextView color = (TextView) findViewById(R.id.colorview);
        pin = (Pinview) findViewById(R.id.pinview1);


        Intent intent = getIntent();
        PasswordSize = intent.getStringExtra("PasswordSize");
        Color = intent.getStringExtra("Color");
        Log.d("s",PasswordSize);
        pin.setPinLength(Integer.parseInt(PasswordSize));
        if(Integer.parseInt(PasswordSize)==8){
            pin.setSplitWidth(10);
        }

        color.setText("Enter " + PasswordSize +" character password");


        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Intent i = new Intent(EnterPasswordActivity.this,ConfirmPasswordActivity.class);
                i.putExtra("PasswordSize",PasswordSize);
                i.putExtra("Color",Color);
                i.putExtra("Password",pin.getValue());
                startActivity(i);
            }
        });
    }
}
