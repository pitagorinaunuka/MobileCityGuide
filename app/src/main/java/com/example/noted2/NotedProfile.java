package com.example.noted2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class NotedProfile extends AppCompatActivity {

        TextView title_placeholder, email_placeholder, pass_placeholder, social_text_placeholder, social_img_placeholder;
        EditText accountEmail, accountPass;
        Button accountChangesBtn, logoutBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_noted_profile);

                accountEmail = findViewById(R.id.account_email_box);
                accountPass = findViewById(R.id.account_pass_box);
                accountChangesBtn = findViewById(R.id.btnSaveUpdate);
                title_placeholder = findViewById(R.id.account_title);
                email_placeholder = findViewById(R.id.account_email);
                pass_placeholder = findViewById(R.id.account_pass);
                social_text_placeholder = findViewById(R.id.social_text);
                social_img_placeholder = findViewById(R.id.social_img);
                logoutBtn = findViewById(R.id.btnLogout);

                ((View) logoutBtn).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent a = new Intent(NotedProfile.this, MainActivity.class);
                                startActivity(a);
                        }
                });


        }
}
