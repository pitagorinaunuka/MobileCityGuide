package com.example.noted2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    ImageView splashImg;
    TextView splashText;
    Button startBtn, signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashImg = findViewById(R.id.splash_img);
        splashText = findViewById(R.id.splashText);
        signBtn = findViewById(R.id.sign_btn);
        startBtn = findViewById(R.id.start_btn);

        ((View) startBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(a);
            }
        });

        handler=new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },600000);

    }






}
