package com.example.ryne.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    IMyService iMyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentService = new Intent(this, MyService.class);
        bindService(intentService, mConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            iMyService = IMyService.Stub.asInterface(iBinder);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public void add(View view) {

        EditText num1 = findViewById(R.id.editText);
        EditText num2 = findViewById(R.id.editText2);

        int value1 = Integer.parseInt(num1.getText().toString());
        int value2 = Integer.parseInt(num2.getText().toString());

        int result = 0;
        try {
            result = iMyService.add(value1, value2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        TextView textView = findViewById(R.id.TextView);
        textView.setText(result);

    }
}
