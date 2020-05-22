package com.example.noted2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SingInActivity extends AppCompatActivity {


    ImageView splashImg;
    EditText emailInput, passInput;
    Button signInBtn;
    TextView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);


        splashImg = findViewById(R.id.splash_img);
        emailInput = findViewById(R.id.email_sign_input);
        passInput = findViewById(R.id.pass_sign_input);
        signInBtn = findViewById(R.id.sign_btn);
        backBtn = findViewById(R.id.back_sign_text);


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
