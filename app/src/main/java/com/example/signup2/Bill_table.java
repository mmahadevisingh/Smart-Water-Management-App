package com.example.signup2;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Bill_table {
    public String uid;
    public int bill_id;
    public String volume;
    public String date;
    public float bill;


    public Map<String, Boolean> billp = new HashMap<>();


    public Bill_table(String uid, int bid,String v,String d,float b) {
        this.uid = uid;
        bill_id=bid;
        volume=v;
        date=d;
        bill=b;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("Bill_id", bill_id);
        result.put("Flow_Rate",volume);
        result.put("date_of_bill",date);
        result.put("Bill_Amount",bill);
        return result;
    }
}



