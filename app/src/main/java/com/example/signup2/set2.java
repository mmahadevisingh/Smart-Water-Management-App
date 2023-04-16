package com.example.signup2;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class set2 {

    String i;


    public void rec(String i) {
        this.i = i;
    }

    public String uid1;
    public String pass1;

    public Map<String, Boolean> stars = new HashMap<>();

    public set2() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public set2(String uid1, String pass1) {
        this.uid1 = uid1;
        this.pass1 = pass1;
    }

    @Exclude
    public Map<String, Object> toMap1() {
        HashMap<String, Object> result1 = new HashMap<>();
        result1.put("uid", uid1);
        result1.put("password", pass1);
        return result1;
    }
}
