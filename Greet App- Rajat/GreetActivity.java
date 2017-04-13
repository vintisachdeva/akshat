package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GreetActivity extends AppCompatActivity implements View.OnClickListener{

    Button submitButton, clearButton;
    TextView resultTextView;
    EditText nameEditText, mobileEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);

        submitButton = (Button)findViewById(R.id.submitButton);
        clearButton = (Button)findViewById(R.id.clearButton);

        resultTextView = (TextView)findViewById(R.id.resultTextView);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        mobileEditText = (EditText)findViewById(R.id.mobileEditText);

        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.submitButton:
                String name = nameEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();

                if(name.equals("") || mobile.equals("")){
                    resultTextView.setText("Fill your details");
                }
                else{
                    resultTextView.setText("Welcome " + name + " " + mobile);
                }


                break;

            case R.id.clearButton:

                nameEditText.setText("");
                mobileEditText.setText("");
                resultTextView.setText("");
                break;

        }

    }
}
