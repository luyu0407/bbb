package com.example.myapplication.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.example.myapplication.R;

public class MoveView extends View {

    int w,h;
    float mX,mY;
    float moveX,moveY;
    private Bitmap mBitmap;
    private Paint mPaint;

    public MoveView(Context context) {
        super(context);
        init(context);
    }

    public MoveView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
//        mScroller = new Scroller(context);

       mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.girl);
       mPaint = new Paint();


    }

    private int lastX, lastY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;//计算滑动的距离
                int offsetY = y - lastY;
                //重新放置新的位置
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                //scrollBy
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
        }
        return true;
    }

//    private int lastX, lastY;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);
//                break;
//        }
//        return true;
//    }


//    private Scroller mScroller;
//    @Override
//    public void computeScroll() { //view在onDraw的时候会调用此方法
//        super.computeScroll();
//        if (mScroller.computeScrollOffset()) {
//            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
//            invalidate();
//        }
//    }
//
//    //在外部调用这个方法即可
//    public void smoothScrollTo(int destX, int destY) {
//        int scrollX = getScrollX();
//        int delta = destX - scrollX;
//        mScroller.startScroll(scrollX, 0, delta,0 ,6000);
//        invalidate();
//    }



//    float startX = 0;
//    float startY = 0;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int action =  event.getAction();
//        int l = this.getLeft();
//        int r = this.getRight();
//        int h = this.getTop();
//        int b = this.getBottom();
//
//        Log.d("MoveView","l = "+l+",r="+r+",,h = "+h+",b="+b);
//
//        switch (action){
//            case MotionEvent.ACTION_DOWN:
//                startX = event.getX();
//                startY = event.getY();
//
//                Log.d("MoveView","startX = "+startX+",startX="+startX);
//                if (startX>0 && startY>0){
//                    //点击在控件里面
//                    return true;
//                }
//                break;
//            case MotionEvent.ACTION_MOVE:
////                Log.d("MoveView","w = "+w+",h="+h);
//                Log.d("MoveView","event.getX = "+event.getX()+",event.getY="+event.getY());
//                Log.d("MoveView","getX = "+getX()+",getY="+getY());
//                mX = event.getX()-startX;
//                mY = event.getY()-startY;
//                invalidate();
//
//                break;
//            case MotionEvent.ACTION_UP:
//                startX =event.getX();
//                startY = event.getY();
//                break;
//        }
//
//        return super.onTouchEvent(event);
//    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//
//        w = mBitmap.getWidth();
//        h = mBitmap.getHeight();
//        moveX+=mX;
//        moveY+=mY;
//
//        canvas.translate(mX,mY);
//        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
//    }
}
