package com.example.myapplication.colorfiter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.R;

public class ColorFiterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_fiter);
//        setContentView(new ColorFilterView(this));

//        ImageView iv = findViewById(R.id.iv);
//
//        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.girl).copy(Bitmap.Config.ARGB_8888,true);
//        Canvas canvas = new Canvas(mBitmap);
//        Paint p = new Paint();
//        p.setColor(Color.RED);
//        p.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(100,100,100,p);
//        iv.setImageBitmap(mBitmap);


    }
}
