package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class adminhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);


        findViewById(R.id.button1).setOnClickListener(view -> {
            Intent intent = new Intent(adminhome.this,statistics.class);
            startActivity(intent);
        });
        findViewById(R.id.button222).setOnClickListener(view -> {
            Intent intent = new Intent(adminhome.this,supply1.class);
            startActivity(intent);
        });
    }
}