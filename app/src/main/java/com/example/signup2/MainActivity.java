package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         FirebaseDatabase firebaseDatabase;

        EditText t1;
         id i;
       // final String[] id1 = new String[1];
       // set p=new set();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aquabal-2b59e-default-rtdb.firebaseio.com/");


        t1=(EditText)findViewById(R.id.editTextTextPersonName);


        i=new id();

        findViewById(R.id.button2).setOnClickListener(view -> {

            String id1 =t1.getText().toString();
            i.setuid(id1);
           // p.rec(i);
          //  databaseReference.child("UserDetails").setValue(i);

            Toast toast = Toast.makeText(this, "stored", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(MainActivity.this,pass.class);
            intent.putExtra("id", id1);
            startActivity(intent);
        });

    }

}

