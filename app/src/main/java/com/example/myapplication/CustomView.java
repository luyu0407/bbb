package com.example.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CustomView extends android.support.v7.widget.AppCompatImageView {

    private Paint mPaint;
    private Path mSrcPath;
    private Paint mBottomPaint;
    private float centerX;
    private float centerY;
    private float r; //半径
    private Path mDstPath;

    private float mLength;
    private ValueAnimator mValueAnimator;
    private float mAnimatedValue;
    private PathMeasure mPathMeasure;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(centerX,centerY,r,mBottomPaint);
        mDstPath.reset();
        float stopD = mAnimatedValue * mLength;
        float startD = 0;
        //获取当前进度的路径，同时赋值给传入的mDstPath
        mPathMeasure.getSegment(startD, stopD, mDstPath, true);


        canvas.save();
        canvas.drawPath(mDstPath, mPaint);
        canvas.restore();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);   //获取宽的模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec); //获取高的模式
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);   //获取宽的尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec); //获取高的尺寸
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY) {
            //如果match_parent或者具体的值，直接赋值
            width = widthSize;
        } else {
            //如果是wrap_content，我们要得到控件需要多大的尺寸
            //控件的宽度就是文本的宽度加上两边的内边距。内边距就是padding值，在构造方法执行完就被赋值
            width = (int) (getPaddingLeft() +  getPaddingRight());

        }
        //高度跟宽度处理方式一样
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {

            height = (int) (getPaddingTop() + getPaddingBottom());

        }

        r = Math.min(width,height)/2;

        //保存测量宽度和测量高度
        setMeasuredDimension(width, height);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("tag","left="+left );
        Log.d("tag","top="+top );
        Log.d("tag","right="+right );
        Log.d("tag","bottom="+bottom );
//        centerX = right - left;
//        centerY = bottom - top;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.d("tag","w="+w );
        Log.d("tag","h="+h );
        Log.d("tag","oldw="+oldw );
        Log.d("tag","oldh="+oldh );


        mPaint = new Paint();
        mSrcPath = new Path();
        mDstPath = new Path();
        mBottomPaint = new Paint();

        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
        //对勾画笔
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(scaledDensity*6);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xFFCFDAE6);
        mPaint.setStrokeCap(Paint.Cap.ROUND); //圆角效果
        mPaint.setStrokeJoin(Paint.Join.MITER);//拐角风格

        centerX= w/2;
        centerY = h/2;
//        r = 200;

        mBottomPaint.setAntiAlias(true);
        mBottomPaint.setColor(0xFFE7F2FD);



        mSrcPath.moveTo(centerX-20*scaledDensity, centerY+15);
        mSrcPath.lineTo(centerX-4*scaledDensity, centerY+20*scaledDensity);
        mSrcPath.lineTo(centerX+22*scaledDensity, centerY-10*scaledDensity);


        //路径测量类
        mPathMeasure = new PathMeasure();
        //测量路径
        mPathMeasure.setPath(mSrcPath, false);

        //获取被测量路径的总长度
        mLength = mPathMeasure.getLength();

        mValueAnimator = ValueAnimator.ofFloat(0, 1);
        mValueAnimator.setDuration(2000);
//        mValueAnimator.setRepeatCount(ValueAnimator.RESTART);
        mValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取从0-1的变化值
                mAnimatedValue = (float) animation.getAnimatedValue();
                //不断刷新绘图，实现路径绘制
                invalidate();
            }
        });

        mValueAnimator.start();
    }


}
