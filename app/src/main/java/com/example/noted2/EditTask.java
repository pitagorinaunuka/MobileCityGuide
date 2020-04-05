package com.example.noted2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditTask extends AppCompatActivity {


    EditText titleNoted, descNoted, dateNoted;
    Button btnSaveUpdate, btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        titleNoted = findViewById(R.id.titlenoted);
        descNoted = findViewById(R.id.descnoted);
        dateNoted = findViewById(R.id.datenoted);

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        // getting values from the previous page
        titleNoted.setText(getIntent().getStringExtra("titlenoted"));
        descNoted.setText(getIntent().getStringExtra("descnoted"));
        dateNoted.setText(getIntent().getStringExtra("datenoted"));

        final String keykeyNote = getIntent().getStringExtra("keynote");


        reference = FirebaseDatabase.getInstance().getReference().child("Noted2")
                .child("Note" + keykeyNote);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Intent a = new Intent(EditTask.this, MainActivity.class);
                            startActivity(a);
                        } else {
                            Toast.makeText(getApplicationContext(), "Failure.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        // button event
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titlenote").setValue(titleNoted.getText().toString());
                        dataSnapshot.getRef().child("descnote").setValue(descNoted.getText().toString());
                        dataSnapshot.getRef().child("datenote").setValue(dateNoted.getText().toString());
                        dataSnapshot.getRef().child("keynote").setValue(keykeyNote);

                        Intent a = new Intent(EditTask.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
