package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.LinkedBlockingDeque;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
//        setContentView(new CustomView(this));

        final ImageView iv = findViewById(R.id.iv);
        final CustomView customView = findViewById(R.id.custom);

        final YAnimation animation = new YAnimation();

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();


        animation.setRepeatCount(1);
        iv.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d("MHW", "onAnimationStart: "+animation.getStartOffset());
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                customView.setVisibility(View.VISIBLE);
                iv.setVisibility(View.GONE);
//                customView.startAnimotion();
                Log.d("MHW", "onAnimationEnd: "+animation.getStartOffset());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d("MHW", "onAnimationRepeat: "+animation.getRepeatCount());
            }

        });



    }
}
