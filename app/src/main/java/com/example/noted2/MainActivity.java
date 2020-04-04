package com.example.noted2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    Button btnAddNew;

    DatabaseReference reference;
    RecyclerView ournoted;
    ArrayList<MyNoted> list;
    NotedAdapter notedAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivity(a);
            }
        });


        // work with the data
        ournoted = findViewById(R.id.ournoted);
        ournoted.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyNoted>();


        // get the data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("Noted2");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // retrieve the data and replace layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MyNoted p = dataSnapshot1.getValue(MyNoted.class);
                    list.add(p);
                }
                notedAdapter = new NotedAdapter(MainActivity.this, list);
                ournoted.setAdapter(notedAdapter);
                notedAdapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // when there is error in the database
                Toast.makeText(getApplicationContext(), "No data to show", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
