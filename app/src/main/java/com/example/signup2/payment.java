package com.example.signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;

import java.util.Objects;

public class payment extends AppCompatActivity {

    TextView a1;
    Button b, b1;
    DatabaseReference reff2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        a1 = (TextView) findViewById(R.id.textView2);
        final String[] bill = new String[1];
        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button10);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff2 = FirebaseDatabase.getInstance().getReference("Bill").child("a-1");
                reff2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        //User user = dataSnapshot.getValue(User.class);
                        bill[0] = snapshot.child("Bill_Amount").getValue().toString();
                        bill[0] = "Rs." + bill[0];

                        a1.setText(bill[0]);
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
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Checkout.preload(getApplicationContext());

                // ...

                //checkout.setKeyID("rzp_test_6wWTW3TT4SAAKQ");



            });
}*/
