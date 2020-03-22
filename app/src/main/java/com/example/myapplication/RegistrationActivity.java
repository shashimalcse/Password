package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    Button submit;
    EditText username;
    EditText email;
    String Username;
    String Email;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);


        submit = (Button) findViewById(R.id.submit);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);

        pref = getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);
        editor =pref.edit();



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Username = username.getText().toString();
                Email = email.getText().toString();
                if(Username.matches("") && Email.matches("")){
                    username.setError("Username not fill");
                    email.setError("Email not fill");
                }
                else if(Username.matches("")){
                    username.setError("Username not fill");
                }
                else if (Email.matches("")){
                    email.setError("Email not fill");
                }
                else{
                    editor.putString("Email",Email);
                    editor.putString("Username",Username);
                    editor.apply();
                    Toast t = Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT);
                    t.show();
                    Intent i = new Intent(RegistrationActivity.this,PasswordSizeActivity.class);
                    startActivity(i);

                }
            }
        });


    }


}
