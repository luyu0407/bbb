package com.example.myapplication.eventbus;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb);

        EventBus.getDefault().register(this);

    }



    public void toEB2(View view) {

        Intent intent = new Intent(this,EB2Activity.class);
        startActivity(intent);

    }


    @Subscribe
    public void aa(MessageEvent me){
        ((TextView)findViewById(R.id.tv)).setText(me.getMes());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void sendEB2(View view) {
        EventBus.getDefault().postSticky(new MessageEvent2("我是页面1 的sticky消息"));

    }
}
