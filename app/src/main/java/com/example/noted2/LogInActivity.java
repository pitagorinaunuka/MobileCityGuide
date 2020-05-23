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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    ImageView splashImg;
    EditText emailInput, passInput;
    Button loginBtn;
    TextView backBtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        splashImg = findViewById(R.id.splash_img);
        emailInput = findViewById(R.id.email_login_input);
        passInput = findViewById(R.id.pass_login_input);
        backBtn = findViewById(R.id.back_login_text);
        loginBtn = findViewById(R.id.login_btn);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LogInActivity.this, "You are successfuly logged in!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LogInActivity.this, "Please log in.", Toast.LENGTH_SHORT).show();
                }
            }
        };


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailInput.getText().toString();
                String pwd = passInput.getText().toString();

                if (email.isEmpty()) {
                    emailInput.setError("Please enter your email.");
                    emailInput.requestFocus();
                } else if (pwd.isEmpty()) {
                    passInput.setError("Please enter your password.");
                    passInput.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LogInActivity.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LogInActivity.this, "Login error. Please try again.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intToMain = new Intent(LogInActivity.this, MainActivity.class);
                                startActivity(intToMain);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LogInActivity.this, "An error occurred.", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ((View) backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b2 = new Intent(LogInActivity.this, SingUpActivity.class);
                startActivity(b2);
            }
        });


        ((View) splashImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(LogInActivity.this, SplashScreenActivity.class);
                startActivity(b1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }




}
