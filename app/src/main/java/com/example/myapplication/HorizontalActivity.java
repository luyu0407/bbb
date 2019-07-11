package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.service.MyIntentService;

public class HorizontalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        Log.e("Activity","onCreate");

        Intent intentService = new Intent(this,MyIntentService.class);
        intentService.putExtra("name","intentService");
        startService(intentService);


        final Object o = new Object();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){


                }
            }
        });
        thread.start();

        Intent intentService2 = new Intent(HorizontalActivity.this,MyIntentService.class);
        intentService2.putExtra("name","intentService2");
        startService(intentService2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity","onResume");
    }
}
