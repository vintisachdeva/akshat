package com.bmpl.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class WiFiActivity extends AppCompatActivity {

    WifiManager wifiManager;

    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi);

        aSwitch = (Switch)findViewById(R.id.switch1);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(wifiManager == null){
                    Toast.makeText(WiFiActivity.this, "Wifi is not available", Toast.LENGTH_SHORT).show();
                }
                else if(!wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(WiFiActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(WiFiActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}