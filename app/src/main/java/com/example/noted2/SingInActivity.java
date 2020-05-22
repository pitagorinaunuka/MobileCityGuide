package com.example.noted2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

public class SingInActivity extends AppCompatActivity {

    ImageView splashImg;
    EditText emailInput, passInput;
    Button signInBtn;
    TextView backBtn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        mFirebaseAuth = FirebaseAuth.getInstance();
        splashImg = findViewById(R.id.splash_img);
        emailInput = findViewById(R.id.email_sign_input);
        passInput = findViewById(R.id.pass_sign_input);
        backBtn = findViewById(R.id.back_sign_text);
        signInBtn = findViewById(R.id.sign_btn);
        signInBtn.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(SingInActivity.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SingInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SingInActivity.this, "Sing up failed. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(SingInActivity.this, MainActivity.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SingInActivity.this, "An error occurred.", Toast.LENGTH_SHORT).show();
                }

            }
        });


        ((View) backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(SingInActivity.this, LogInActivity.class);
                startActivity(b1);
            }
        });


        ((View) splashImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(SingInActivity.this, SplashScreenActivity.class);
                startActivity(b1);
            }
        });
    }
}
