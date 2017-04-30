package com.bmpl.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter arrayAdapter;
    WebView webView;

    String data[] = {"Froyo", "Icecream-Sandwich","Lollipop", "Marshmallow", "Nougat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data);

        autoCompleteTextView.setAdapter(arrayAdapter);

        webView.loadUrl("https://www.google.co.in/?gfe_rd=cr&ei=RcoFWfTiGers8AfdxpewBQ");
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
