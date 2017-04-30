package com.bmpl.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    int images[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher};

    String data[]={"C", "C++", "Java", "Android", "DS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new CustomAdapter(this, images, data));
    }
}
