package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class userhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userhome);

        findViewById(R.id.button2).setOnClickListener(view -> {
            Intent intent = new Intent(userhome.this,userstat.class);
            startActivity(intent);
        });
        findViewById(R.id.lg).setOnClickListener(view -> {
            Intent intent = new Intent(userhome.this,Login.class);
            startActivity(intent);
        });
        findViewById(R.id.button).setOnClickListener(view -> {
            SimpleDateFormat sdf = new SimpleDateFormat("'Date\n'dd-MM-yyyy");

            // on below line we are creating a variable
            // for current date and time and calling a simple date format in it.
            String currentDate = sdf.format(new Date());
           // TextView t= (TextView) findViewById(R.layout.activity_due.textView10);
           // if(currentDate.equals(t.getText().toString())) {
                Intent intent = new Intent(userhome.this, payment.class);
                startActivity(intent);
            //}
           /* else
            {
                Intent intent = new Intent(userhome.this, payment.class);
                startActivity(intent);
            }*/
        });
        }

    }
