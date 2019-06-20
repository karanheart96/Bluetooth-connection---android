package com.kayak.bluetooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.bluetooth.*;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAdapter bluetooth = BluetoothAdapter.getDefaultAdapter();
        if(bluetooth != null)
        {
            // Continue with bluetooth setup.
            String status;
            if (bluetooth.isEnabled()) {
                String mydeviceaddress = bluetooth.getAddress();
                String mydevicename = bluetooth.getName();
                status = mydevicename + " : "+ mydeviceaddress;
                String state = String.valueOf(bluetooth.getState());
                status = mydevicename + " : " + mydeviceaddress + " : " + state;
                status = "just checking";
            }
            else
            {
                status = "Bluetooth is not enabled";
            }
            Toast.makeText(this, status, Toast.LENGTH_LONG).show();
            Log.d("status=",status);
            bluetooth.setName("AndroidCoder");
        }
        else{
            Toast.makeText(this,"bluetooth not enabled",Toast.LENGTH_LONG).show();;
        }


    }
}
