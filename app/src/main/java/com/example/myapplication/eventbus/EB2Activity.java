package com.example.myapplication.eventbus;

import android.app.Activity;
import android.content.Context;
import android.graphics.PathMeasure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EB2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb2);
        EventBus.getDefault().register(this);


    }

    public void sendMes(View view) {

        EventBus.getDefault().post(new MessageEvent("EB2 发来的消息"));

    }

    @Subscribe(sticky = true)
    public void bb(MessageEvent2 me){
        ((TextView)findViewById(R.id.tv)).setText(me.getMes());
    }
}
