package com.example.signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



         Button lb;
        final String[] name =new String[1];
        final String[] pass =new String[1];


        EditText etloginname = (EditText) findViewById(R.id.username);
        EditText etloginpass = (EditText) findViewById(R.id.password);



        final String[] passr = new String[1];

        findViewById(R.id.button).setOnClickListener(view -> {

            name[0] = etloginname.getText().toString();
            pass[0] = etloginpass.getText().toString();

            DatabaseReference databaseReference;
            databaseReference = FirebaseDatabase.getInstance().getReference("UserDetails");
            
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // this method is call to get the realtime
                    // updates in the data.
                    // this method is called when the data is
                    // changed in our Firebase console.
                    // below line is for getting the data from
                    // snapshot of our database.

                if(snapshot.exists()){
                        String idr = snapshot.child("uid").getValue(String.class);
                        passr[0] = snapshot.child("password").getValue(String.class);
                        //Toast.makeText(Login.this, "Success!!", Toast.LENGTH_SHORT).show();
                        if (pass[0].equals(passr[0])) {

                            Toast.makeText(Login.this, "Success!!", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(Login.this, passr[0], Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Login.this, "No such Username exists!!", Toast.LENGTH_SHORT).show();
                    }


                    //DatabaseReference db= FirebaseDatabase.getInstance().getReference("UserDetails");
                    //db.child(value).setValue(ta);
                    //uid2[0] =value;
                    // after getting the value we are setting
                    // our value to our text view in below line.
                }

                @Override

                public void onCancelled(@NonNull DatabaseError error) {
                    // calling on cancelled method when we receive
                    // any error or we are not able to get the data.
                    Toast.makeText(Login.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                }
            });
        });


    }
}

