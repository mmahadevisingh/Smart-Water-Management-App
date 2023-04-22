package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class userhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

        findViewById(R.id.button2).setOnClickListener(view -> {
            Intent intent = new Intent(userhome.this,userstat.class);
            startActivity(intent);
        });
        findViewById(R.id.button).setOnClickListener(view -> {
            Intent intent = new Intent(userhome.this,payment.class);
            startActivity(intent);
        });
        }

    }
