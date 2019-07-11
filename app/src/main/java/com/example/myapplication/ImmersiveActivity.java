package com.example.myapplication;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yzbzz.media.library.utils.FFmpegCmdUtils;

public class ImmersiveActivity extends AppCompatActivity {

    public static String testStr = "qwerty";

    public static void changeStr(){
        testStr = "asdfg";
    }
    private int n = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        immersive();
        testStr = "zxcvb";


        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i<255 ; i++){
                    for(int j = 0 ;j<255 ; j++){
                        for(int k = 0 ;k<255 ; k++){
                            Log.e("statictest","n="+n++);
                        }}}
            }
        }).start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("statictest","onDestroy");
    }

    private void immersive(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色透明
            window.setStatusBarColor(Color.TRANSPARENT);

            int visibility = window.getDecorView().getSystemUiVisibility();
            //布局内容全屏展示
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            //隐藏虚拟导航栏
            visibility |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            //防止内容区域大小发生变化
            visibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

            window.getDecorView().setSystemUiVisibility(visibility);
        }else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

    }

    public void change(View view) {
        changeStr();
    }
}
