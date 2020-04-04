package com.example.noted2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NotedAdapter extends RecyclerView.Adapter<NotedAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyNoted> myNoted;

    public NotedAdapter(Context c, ArrayList<MyNoted> p) {
        context = c;
        myNoted = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_noted, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.titlenoted.setText(myNoted.get(i).getTitlenoted());
        myViewHolder.descnoted.setText(myNoted.get(i).getDescnoted());
        myViewHolder.datenoted.setText(myNoted.get(i).getDatenoted());

    }

    @Override
    public int getItemCount() {

        return myNoted.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titlenoted, descnoted, datenoted;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titlenoted = (TextView) itemView.findViewById(R.id.titlenoted);
            descnoted = (TextView) itemView.findViewById(R.id.descnoted);
            datenoted = (TextView) itemView.findViewById(R.id.datenoted);

        }
    }
}
