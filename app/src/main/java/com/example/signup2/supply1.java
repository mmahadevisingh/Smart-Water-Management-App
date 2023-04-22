package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class supply1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supply1);
        findViewById(R.id.button12).setOnClickListener(view -> {
            Toast.makeText(this, "Supply cut down", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.button11).setOnClickListener(view -> {
            Toast.makeText(this, "Supply started", Toast.LENGTH_SHORT).show();
        });

    }
}