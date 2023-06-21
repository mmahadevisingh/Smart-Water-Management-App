package com.example.signup2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;
    private lis l;


    public MyAdapter(Context context, ArrayList<User> list,lis l ) {

        this.context = context;
        this.list = list;
        this.l=l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        User user = list.get(position);
        holder.Userid.setText(user.getUserid());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l.onItemClicked(list.get(position));
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView Userid;
        public CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Userid = itemView.findViewById(R.id.uname);
            cardView=itemView.findViewById(R.id.main_container);
        }
    }

}

