package com.example.signup2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;
@IgnoreExtraProperties
public class set {
    String i;
    DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference("Admin");


    public void rec(String i)
    {
       this. i=i;
    }
        public String uid;
        public String pass;

        public Map<String, Boolean> stars = new HashMap<>();

        public set() {
            // Default constructor required for calls to DataSnapshot.getValue(Post.class)
        }

        public set(String uid, String pass) {
            this.uid = uid;
            this.pass=pass;
        }

    public String getPass() {
        return pass;
    }

    @Exclude
        public Map<String, Object> toMap() {
            HashMap<String, Object> result = new HashMap<>();
            result.put("uid", uid);
            result.put("password", pass);
            return result;
        }
    }



