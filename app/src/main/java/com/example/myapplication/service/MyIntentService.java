package com.example.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
    }


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final String s =intent.getStringExtra("name");
        Log.e(TAG, "onHandleIntent");
        final Thread thread = new Thread();
        if (s.contains("2")){
            for (int i = 0; i < 100; i++) {
                Log.e(TAG, "onHandleIntent-----------------" + i+s);
            }
        }else {
            final Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (thread) {
                        try {
                            thread.wait(1000);
                            for (int i = 0; i < 100; i++) {
                                Log.e(TAG, "onHandleIntent-----------------" + i+s);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });

            t.start();

        }


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e(TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");


        super.onDestroy();
    }
}
