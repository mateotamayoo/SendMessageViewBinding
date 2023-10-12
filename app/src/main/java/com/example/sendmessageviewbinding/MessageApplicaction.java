package com.example.sendmessageviewbinding;

import android.app.Application;
import android.util.Log;

public class MessageApplicaction extends Application {


    public static final String TAG="MessageApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "MessageApplication -> OnCreate()");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
