package com.bmpl.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    Button yes, no;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        yes = (Button)findViewById(R.id.yesButton);
        no = (Button)findViewById(R.id.noButton);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        Intent intent = getIntent();
        name = intent.getStringExtra("userName");
        String spinner = intent.getStringExtra("spinner");
        Toast.makeText(this, "Welcome " + name + " " + spinner , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yesButton:
                Intent intent = new Intent();
                intent.putExtra("name",name);
                setResult(RESULT_OK,intent);
                finish();//finish will close the current activity and don't put it in the stack
                break;

            case R.id.noButton:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}