package com.example.signup2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class start extends AppCompatActivity {

    Button signup;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        signup = findViewById(R.id.button);
        login = findViewById(R.id.button2);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(start.this,decide.class);

               String i="1";
                //intent.putExtra("i",i);
                intent.putExtra("message", i);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(start.this,decide.class);
                String i="0";
                //intent.putExtra("i",i);
                intent.putExtra("message", i);
                startActivity(intent);
                finish();
            }
        });
    }
}