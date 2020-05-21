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
    EditText nameInput, emailInput, passInput;
    Button signInBtn;
    TextView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);


        splashImg = findViewById(R.id.splash_img);
        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        passInput = findViewById(R.id.pass_input);
        signInBtn = findViewById(R.id.sign_btn);
        backBtn = findViewById(R.id.back_sign_text);


        ((View) backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b1 = new Intent(SingInActivity.this, LogInActivity.class);
                startActivity(b1);
            }
        });

    }
}
