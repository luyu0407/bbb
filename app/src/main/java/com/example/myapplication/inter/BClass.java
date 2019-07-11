package com.example.myapplication.inter;

import android.util.Log;

public class BClass implements AInter {
    @Override
    public int get() {
        Log.e("Proxy123","BClass get");
        return 89;
    }
}
