package com.example.noted2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SingUpActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    ImageView splashImg;
    EditText emailInput, passInput, nameInput;
    Button signInBtn;
    TextView backBtn;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        nameInput = findViewById(R.id.name_sign_input);
        splashImg = findViewById(R.id.splash_img);
        emailInput = findViewById(R.id.email_sign_input);
        passInput = findViewById(R.id.pass_sign_input);
        backBtn = findViewById(R.id.back_sign_text);
        signInBtn = findViewById(R.id.sign_btn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = emailInput.getText().toString();
                final String pwd = passInput.getText().toString();
                final String name = nameInput.getText().toString();

                if (email.isEmpty()) {
                    emailInput.setError("Please enter your email.");
                    emailInput.requestFocus();
                } else if (pwd.isEmpty()) {
                    passInput.setError("Please enter your password.");
                    passInput.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(SingUpActivity.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SingUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SingUpActivity.this, "Sing up failed. Please try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                userID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = fStore.collection("users").document(userID);
                                Map<String, Object> user = new HashMap<>();
                                user.put("email", email);
                                user.put("password", pwd);
                                user.put("name", name);
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "onSuccess: the profile is created "+ userID);
                                    }
                                });

                                startActivity(new Intent(SingUpActivity.this, MainActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SingUpActivity.this, "An error occurred.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        ((View) backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(SingUpActivity.this, LogInActivity.class);
                startActivity(b1);
            }
        });


        ((View) splashImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(SingUpActivity.this, SplashScreenActivity.class);
                startActivity(b1);
            }
        });
    }
}
