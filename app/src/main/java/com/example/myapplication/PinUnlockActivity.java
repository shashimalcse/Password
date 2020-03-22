package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class PinUnlockActivity extends AppCompatActivity {
    private Pinview pin;
    private String Pin;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private String Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_unlock);

        pref = getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);

        TextView color = (TextView) findViewById(R.id.PinDescription);
        pin = (Pinview) findViewById(R.id.PinUnlock);

        Pin = pref.getString("Password",null);

        pin.setPinLength(4);

        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Confirm = pin.getValue();
                if (Pin.equals(Confirm)){
                    Toast t = Toast.makeText(getApplicationContext(),pref.getString("Password",null),Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(PinUnlockActivity.this,SuccessActivity.class);
                    startActivity(i);
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
