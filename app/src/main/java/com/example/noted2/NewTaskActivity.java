package com.example.noted2;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskActivity extends AppCompatActivity {

    TextView titlepage, addtitle, adddesc, adddate;
    EditText titlenoted, descnoted, datenoted;
    Button btnSaveTask, btnCancel;
    DatabaseReference reference;
    Integer notedNum = new Random().nextInt();
    String keynote = Integer.toString(notedNum);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        titlepage = findViewById(R.id.titlepage);

        addtitle = findViewById(R.id.addtitle);
        adddesc = findViewById(R.id.adddescs);
        adddate = findViewById(R.id.adddate);

        titlenoted = findViewById(R.id.titlenoted);
        descnoted = findViewById(R.id.descnoted);
        datenoted = findViewById(R.id.datenoted);

        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnCancel = findViewById(R.id.btnCancel);



        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // insertion to the database
                reference = FirebaseDatabase.getInstance().getReference().child("Noted2")
                        .child("Note" + notedNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("titlenote").setValue(titlenoted.getText().toString());
                        dataSnapshot.getRef().child("descnote").setValue(descnoted.getText().toString());
                        dataSnapshot.getRef().child("datenote").setValue(datenoted.getText().toString());
                        dataSnapshot.getRef().child("keynote").setValue(keynote);

                        Intent a = new Intent(NewTaskActivity.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
