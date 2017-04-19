package com.bmpl.registrationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    Button createAccount;
    EditText nameEditText;
    Spinner spinner;

    String spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccount = (Button)findViewById(R.id.button);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                  spinnerValue = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //anonymous class and interface

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameEditText.getText().toString();
                //source--> curent activity
                //destination--> activity to open
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                intent.putExtra("userName",name);
                intent.putExtra("spinner", spinnerValue);
                startActivity(intent);//must to have
            }
        });
    }
}
