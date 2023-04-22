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

public class userstat extends AppCompatActivity {

    TextView a, b, c, d, e;
    Button btn;
    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userstat);

        a = (TextView) findViewById(R.id.textView111);
        b = (TextView) findViewById(R.id.textView181);
        e = (TextView) findViewById(R.id.textView222);
        btn = (Button) findViewById(R.id.button51);
        final String[] volume = new String[1];
        final String[] date = new String[1];
        final String[] tankid = new String[1];


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference("Flow").child("20");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        //User user = dataSnapshot.getValue(User.class);
                        date[0] = snapshot.child("Date").getValue(String.class);
                        tankid[0] = snapshot.child("Tank_Id").getValue(String.class);
                        //String userid=snapshot.child("userId").getValue(String.class);
                        volume[0] = Objects.requireNonNull(snapshot.child("Volume").getValue()).toString();
                        a.setText(date[0]);
                        b.setText(tankid[0]);
                        e.setText(volume[0]);
                    }
                    // }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}


