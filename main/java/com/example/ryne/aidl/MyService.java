package com.example.ryne.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    IMyService.Stub mBinder = new IMyService.Stub() {
        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }
    };


}
