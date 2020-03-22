package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

public class ConfirmPasswordActivity extends AppCompatActivity {

    private String PasswordSize;
    private String Color;
    private Pinview pin;
    private String Password;
    private String Confirm;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);

        pref = getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);
        editor =pref.edit();

        TextView ConfirmDescription = (TextView) findViewById(R.id.ConfirmDescription);
        ConfirmDescription.setText("Confirm your Password");

        Intent intent = getIntent();

        PasswordSize = intent.getStringExtra("PasswordSize");
        Color = intent.getStringExtra("Color");
        Password = intent.getStringExtra("Password");

        pin = (Pinview) findViewById(R.id.pinview2);

        pin.setPinLength(4);


        pin.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Confirm = pin.getValue();
                if (Password.equals(Confirm)){
                    editor.putString("Password",Password);
                    editor.putInt("PasswordSize",Integer.parseInt(PasswordSize));
                    editor.putString("Color",Color);
                    editor.apply();
                    Toast t = Toast.makeText(getApplicationContext(),pref.getString("Password",null),Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(ConfirmPasswordActivity.this,SpinActivity.class);
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
