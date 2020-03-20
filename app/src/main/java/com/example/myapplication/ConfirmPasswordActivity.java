package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class ConfirmPasswordActivity extends AppCompatActivity {

    private String PasswordSize;
    private String Color;
    private Pinview pin;
    private String Password;
    private String Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);

        Intent intent = getIntent();

        PasswordSize = intent.getStringExtra("PasswordSize");
        Color = intent.getStringExtra("Color");
        Password = intent.getStringExtra("Password");

        pin = (Pinview) findViewById(R.id.pinview2);

        pin.setPinLength(Integer.parseInt(PasswordSize));
        if(Integer.parseInt(PasswordSize)==8){
            pin.setSplitWidth(10);
        }

        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Confirm = pin.getValue();
                if (Password.equals(Confirm)){
                    Toast t = Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT);
                    t.show();
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(),"NOT MATCH",Toast.LENGTH_SHORT);
                    t.show();
                    pin.clearValue();
                }

            }
        });


    }
}
