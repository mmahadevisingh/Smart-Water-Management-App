package com.example.signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class stastics extends AppCompatActivity {
    TextView a,b,c,d,e;
    Button btn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stastics);

        a=(TextView) findViewById(R.id.textView11);
        b=(TextView) findViewById(R.id.textView13);
        c=(TextView) findViewById(R.id.textView18);
        d=(TextView) findViewById(R.id.textView20);
        e=(TextView) findViewById(R.id.textView22);
        btn=(Button) findViewById(R.id.button5);
        final String[] volume = new String[1];
        final String[] uid = new String[1];
        final String[] date=new String[1];
        final String[] flowrate = new String[1];
        final String[] tankid=new String[1];


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference("Flow").child("26");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        //User user = dataSnapshot.getValue(User.class);
                        uid[0] = snapshot.child("UserID").getValue(String.class);
                        date[0] = snapshot.child("Date").getValue(String.class);
                        flowrate[0] = Objects.requireNonNull(snapshot.child("Flow_Rate").getValue()).toString();
                        tankid[0] = snapshot.child("Tank_Id").getValue(String.class);
                        //String userid=snapshot.child("userId").getValue(String.class);
                        volume[0] = Objects.requireNonNull(snapshot.child("Volume").getValue()).toString();
                        a.setText(date[0]);
                        b.setText(flowrate[0]);
                        c.setText(tankid[0]);
                        d.setText(uid[0]);
                        e.setText(volume[0]);
                    }
                                           // }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        findViewById(R.id.button6).setOnClickListener(view2 -> {
                   // volume[0] = Objects.requireNonNull(snapshot.child("Volume").getValue()).toString();
                    float bill= Float.parseFloat(volume[0])*10;
                    int bill_id= ((int) (Math.random()*1000));

                    Bill_table b=new Bill_table(uid[0],bill_id,volume[0],date[0],bill);
                    Map<String, Object> postValues = b.toMap();

                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put(uid[0], postValues);
                    //childUpdates.put("/password/" + id + "/" + key, postValues);
                    DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference("Bill");
                    myRootRef.updateChildren(childUpdates);

                    Toast toast = Toast.makeText(this, "Generated", Toast.LENGTH_SHORT);
                    toast.show();

                    });

                }

    }
