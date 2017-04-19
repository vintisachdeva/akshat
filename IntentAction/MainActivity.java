package com.bmpl.intentaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.sendButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text");
                    intent.putExtra(Intent.EXTRA_TEXT, "This is my text");
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "No app to send data", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}