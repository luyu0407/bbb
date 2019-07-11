package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NDKActivity extends AppCompatActivity {


    static {
        System.loadLibrary("jni-test");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);

        TextView tv = findViewById(R.id.tv);
        tv.setText(get());
        set("hello world from JniTestApp");
    }

    public native String get();
    public native void set(String str);
}
