package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class adpass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adpass);
        EditText t1,t3;
        //i2.setuid(i[0]);
        // set s=new set();
        final String[] p2 = new String[1];
        final String[] p3 = new String[1];
        t1=(EditText)findViewById(R.id.editTextTextPassword4);
        t3=(EditText)findViewById(R.id.editTextTextPassword8);
        final String[] id1 = new String[1];


        findViewById(R.id.button9).setOnClickListener(view -> {
            p2[0] =t1.getText().toString();
            // s.i.setpass(p[0]);
            p3[0] =t3.getText().toString();


            if(p2[0].equals(p3[0]))
            {
                id1[0] = getIntent().getStringExtra("id");
                //String id=s.i;
                //DatabaseReference ref = myRootRef.child(id);



                set2 pos = new set2(id1[0], p3[0]);
                Map<String, Object> postV = pos.toMap1();

                Map<String, Object> childUpdat = new HashMap<>();
                childUpdat.put(id1[0], postV);
                //childUpdates.put("/password/" + id + "/" + key, postValues);
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
                databaseReference.updateChildren(childUpdat);
                //databaseReference.child("UserDetails").setValue(s.i);

                Toast toast = Toast.makeText(this, "stored", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(this, "Cannot confirm password!!", Toast.LENGTH_SHORT);
                toast.show();
            }
            Toast toast = Toast.makeText(this, "done", Toast.LENGTH_SHORT);
            toast.show();
        });
    }
}

