package com.example.grappass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PasswordSizeSelectionActivity extends AppCompatActivity {

    TextView four;
    TextView six;
    TextView eight;
    int passwordSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_size_selection);

        four = (TextView) findViewById(R.id.four);
        six = (TextView) findViewById(R.id.six);
        eight = (TextView) findViewById(R.id.eight);

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordSize=4;
                Intent intent = new Intent(PasswordSizeSelectionActivity.this,ColorSelectionActivity.class);
                intent.putExtra("PasswordSize",passwordSize);
                startActivity(intent);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordSize=6;
                Intent intent = new Intent(PasswordSizeSelectionActivity.this,ColorSelectionActivity.class);
                intent.putExtra("PasswordSize",passwordSize);
                startActivity(intent);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordSize=8;
                Intent intent = new Intent(PasswordSizeSelectionActivity.this,ColorSelectionActivity.class);
                intent.putExtra("PasswordSize",passwordSize);
                startActivity(intent);
            }
        });



    }


}
