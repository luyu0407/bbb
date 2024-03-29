package com.example.myapplication.colorfiter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;


public class ColorFilterView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private ColorMatrixColorFilter mColorMatrixColorFilter;

    public ColorFilterView(Context context) {
        super(context);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.girl);

    }

    public ColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.girl);
    }

    public ColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         */
        //红色去除掉
//        LightingColorFilter lighting = new LightingColorFilter(0x00ffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap, 0,0, mPaint);

//        //原始图片效果
//        LightingColorFilter lighting = new LightingColorFilter(0xffffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap, 0,0, mPaint);

//        //绿色更亮
//        LightingColorFilter lighting = new LightingColorFilter(0xffffff,0x003000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap, 0,0, mPaint);

//        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
//        mPaint.setColorFilter(porterDuffColorFilter);
//        canvas.drawBitmap(mBitmap, 100, 0, mPaint);

        float[] colorMatrix = {
                2,0,0,0,0,   //red
                0,1,0,0,0,   //green
                0,0,1,0,0,   //blue
                0,0,0,1,0    //alpha
        };

//        ColorMatrix cm = new ColorMatrix();
//        //亮度调节
//        cm.setScale(1,2,1,1);

//        //饱和度调节0-无色彩， 1- 默认效果， >1饱和度加强
//        cm.setSaturation(2);

        //色调调节
//        cm.setRotate(0, 45);

//        mColorMatrixColorFilter = new ColorMatrixColorFilter(cm);
//        mPaint.setColorFilter(mColorMatrixColorFilter);
//        canvas.drawBitmap(mBitmap, 100, 0, mPaint);


        float colormatrix_heibai[] = {
            0.8f, 1.6f, 0.2f, 0, -163.9f,
                    0.8f, 1.6f, 0.2f, 0, -163.9f,
                    0.8f, 1.6f, 0.2f, 0, -163.9f,
                    0, 0, 0, 1.0f, 0};

        mPaint.setColorFilter(new ColorMatrixColorFilter(colormatrix_heibai));
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
//        canvas.drawCircle(100,100,100,mPaint);
//        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.girl).copy(Bitmap.Config.ARGB_8888,true);
//        mPaint.setColor(Color.RED);
//        canvas.drawCircle(100,100,100,mPaint);
//        Canvas canvas2 =new Canvas(mBitmap);
//        canvas2.drawCircle(600,600,100,mPaint);

    }

    // 胶片
    public static final float colormatrix_fanse[] = {
            -1.0f, 0.0f, 0.0f, 0.0f, 255.0f,
            0.0f, -1.0f, 0.0f, 0.0f, 255.0f,
            0.0f, 0.0f, -1.0f, 0.0f, 255.0f,
            0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
}
