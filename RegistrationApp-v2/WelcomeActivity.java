package com.bmpl.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        String spinner = intent.getStringExtra("spinner");
        Toast.makeText(this, "Welcome " + name + " " + spinner , Toast.LENGTH_LONG).show();
    }
}