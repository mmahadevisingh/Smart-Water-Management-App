package com.example.signup2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class decide extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button button2;
        Button bt;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide);
        button2 = findViewById(R.id.button3);
        bt=findViewById(R.id.button4);
        String i = getIntent().getStringExtra("message");

        button2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                if(i.equals("1")) {

                    Intent intent = new Intent(decide.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(decide.this, Login.class);
                    startActivity(intent);
                }


            }
        });


            bt.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    if(i.equals("1")) {
                        Intent intent = new Intent(decide.this, signupadmin.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(decide.this, Login.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }



/*public class decide extends AppCompatActivity {
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decide);
        button2=findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(decide.this,start.class);
                startActivity(intent);
            }
        });
    }
}*/