package com.bmpl.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity implements View.OnClickListener {

    Switch bluetoothSwitch;
    Button visible, pairedDevice;
    ListView listView;
    BluetoothAdapter bluetoothAdapter;

    Set<BluetoothDevice> bluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        //check that bluetooth driver is available or not
        // --> if available then enable or disable

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        bluetoothSwitch = (Switch)findViewById(R.id.bluetoothSwitch);
        visible = (Button)findViewById(R.id.visibleButton);
        pairedDevice = (Button)findViewById(R.id.pairedDeviceButton);
        listView = (ListView)findViewById(R.id.listView);

        visible.setOnClickListener(this);
        pairedDevice.setOnClickListener(this);


        bluetoothSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(bluetoothAdapter == null){
                    Toast.makeText(BluetoothActivity.this, "Bluetooth driver is not available", Toast.LENGTH_SHORT).show();
                }
                else if(!bluetoothAdapter.isEnabled()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(BluetoothActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                } else {
                    bluetoothAdapter.disable();
                    Toast.makeText(BluetoothActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.visibleButton:
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 3000);
                startActivity(intent);
                Toast.makeText(BluetoothActivity.this, "Visible", Toast.LENGTH_SHORT).show();
                break;


            case R.id.pairedDeviceButton:

                bluetoothDevice = bluetoothAdapter.getBondedDevices();

                ArrayList arrayList = new ArrayList();

                for(BluetoothDevice bluetoothDevice1:bluetoothDevice){

                    arrayList.add(bluetoothDevice1.getName());

                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(BluetoothActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);

                listView.setAdapter(arrayAdapter);

                break;
        }
    }
}
