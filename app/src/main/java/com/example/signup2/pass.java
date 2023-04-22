package com.example.signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class pass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        EditText t,t2;
        //i2.setuid(i[0]);
      // set s=new set();
        final String[] p = new String[1];
        final String[] p1 = new String[1];
        t=(EditText)findViewById(R.id.editTextTextPassword);
        t2=(EditText)findViewById(R.id.editTextTextPassword2);
        //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aquabal-2b59e-default-rtdb.firebaseio.com/");

        findViewById(R.id.button).setOnClickListener(view -> {
            p[0] =t.getText().toString();
           // s.i.setpass(p[0]);
            p1[0] =t2.getText().toString();


            if(p1[0].equals(p[0]))
            {
               String id = getIntent().getStringExtra("id");
                //String id=s.i;
                DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference("UserDetails");
               //DatabaseReference ref = myRootRef.child(id);

                //String key = myRootRef.child("id");
                set post = new set(id,p1[0]);
                Map<String, Object> postValues = post.toMap();

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put(id, postValues);
                //childUpdates.put("/password/" + id + "/" + key, postValues);
                myRootRef.updateChildren(childUpdates);




                //databaseReference.child("UserDetails").setValue(s.i);

                Toast toast = Toast.makeText(this, "stored", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(pass.this,userhome.class);
                startActivity(intent);
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