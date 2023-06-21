package com.example.signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class LoginAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        Button lb;
        final String[] name =new String[1];
        final String[] pass =new String[1];
        final int[] c=new int[1];
        final int[] p=new int[1];
        c[0]=0;
        p[0]=0;


        EditText etloginname = (EditText) findViewById(R.id.username2);
        EditText etloginpass = (EditText) findViewById(R.id.password2);



        //final String[] passr = new String[1];

        findViewById(R.id.button123).setOnClickListener(view -> {

            name[0] = etloginname.getText().toString();
            pass[0] = etloginpass.getText().toString();
            String name2=name[0];

            //DatabaseReference databaseReference;
            //databaseReference = FirebaseDatabase.getInstance().getReference("UserDetails");
            //pass p=new pass();
            set2 post=new set2();



            post.databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    // this method is call to get the realtime
                    // updates in the data.
                    // this method is called when the data is
                    // changed in our Firebase console.
                    // below line is for getting the data from
                    // snapshot of our database.

                    //if (snapshot.exists()) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            // Get the user object from the snapshot
                            //User user = userSnapshot.getValue(User.class);
                            final String passr = dataSnapshot.child("password").getValue(String.class);
                             final String uid = dataSnapshot.child("uid").getValue(String.class);
                             int x=name2.length();
                             String s=Integer.toString(x);
                            int x2=uid.length();
                            String s2=Integer.toString(x2);
                           // s2.trim();



                            //assert uid != null;
                            if (uid.equals(name2)) {
                                p[0] = 1;
                                Toast.makeText(LoginAdmin.this, "click", Toast.LENGTH_SHORT).show();

                                if (pass[0].equals(passr)) {
                                    c[0] = 1;
                                    break;
                                }
                            }
                            else
                                Toast.makeText(LoginAdmin.this, "not", Toast.LENGTH_SHORT).show();

                        }



                                    if(p[0]==1){
                                    if(c[0]==1)
                                    {

                                    Toast.makeText(LoginAdmin.this, "Success!!", Toast.LENGTH_SHORT).show();
                                        Intent intent2 = new Intent(LoginAdmin.this,adminhome.class);
                                        startActivity(intent2);

                                } else {
                                    Toast.makeText(LoginAdmin.this, "Failed!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                    Intent intent = new Intent(LoginAdmin.this,adminhome.class);
                    startActivity(intent);
                                    /*else {
                                Toast.makeText(LoginAdmin.this, "No such Username exists!!", Toast.LENGTH_SHORT).show();
                            }*/
                            //DatabaseReference db= FirebaseDatabase.getInstance().getReference("UserDetails");
                            //db.child(value).setValue(ta);
                            //uid2[0] =value;
                            // after getting the value we are setting
                            // our value to our text view in below line.

                        }



                @Override

                public void onCancelled (@NonNull DatabaseError error){
                    // calling on cancelled method when we receive
                    // any error or we are not able to get the data.
                    Toast.makeText(LoginAdmin.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
                }



            });
        });

    }
}