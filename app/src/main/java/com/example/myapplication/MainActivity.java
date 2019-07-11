package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.inter.AInter;
import com.example.myapplication.inter.BClass;
import com.example.myapplication.util.DensityUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    private int pos;
    private volatile int status;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DensityUtil.setDensity(getApplication(),this);

        ThreadLocal<String> tl1 = new ThreadLocal<>();
        ThreadLocal<Integer> tl2 = new ThreadLocal<>();

        tl1.set("mhw");
        tl2.set(10);

        Log.e("MHW -->","tl1.get()="+tl1.get());
        Log.e("MHW -->","tl2.get()="+tl2.get());



        for (int i =0 ;i<10;i++){
            list.add("条目"+i);
        }

        Log.d("tag","pos"+pos);
//        for (String a:list){
//            if (a.equals("条目8")){
//                list.remove(a);
//            }
//        }

        for (int i=0;i<list.size();i++){
            if (list.get(i).contains("2")){
                list.remove(i);
            }
        }

        Glide.with(this).load("").into(new ImageView(this));

        AInter bClass = (AInter) proxy(new BClass());
        bClass.get();










//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();




        // WindowManager
//       findViewById(R.id.btn1).postDelayed(new Runnable() {
//           @Override
//           public void run() {
//               checkPer();
//           }
//       },1000);


//        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(MainActivity.this,SecondAcitvity.class);
//                startActivity(intent);
//            }
//        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(MainActivity.this, MusicListActivity.class);
//                startActivity(intent);


                Intent intent =new Intent(MainActivity.this, HorizontalActivity.class);
                startActivity(intent);
            }
        });

//
//        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(MainActivity.this,AnimationActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,PathMeasureActivity.class);
//                startActivity(intent);
//            }
//        });
//        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,CustomViewActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private Object proxy(final Object target) {
        Class clazz = Proxy.getProxyClass(target.getClass().getClassLoader(),target.getClass().getInterfaces());
        try {
            Constructor<?> constructors =  clazz.getConstructor(InvocationHandler.class);
            return constructors.newInstance(new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    Log.e("Proxy123", "proxy="+proxy.getClass().getSimpleName());
                    Log.e("Proxy123", "method="+method.getName() );

                    Object reault = method.invoke(target, args);
                    Log.e("Proxy123", "reault="+reault.getClass().getSimpleName() );
                    Log.e("Proxy123", "reault="+reault);
                    return reault;
                }
            });
        } catch (Exception e) {
            Log.e("Proxy123","proxy="+e.toString());

        }
        return null;
    }


//    public void drawVertical(Canvas c, RecyclerView parent) {
//        final int left = parent.getPaddingLeft();
//        final int right = parent.getWidth() - parent.getPaddingRight();
//
//        final int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            final View child = parent.getChildAt(i);
//            android.support.v7.widget.RecyclerView v = new android.support.v7.widget.RecyclerView(parent.getContext());
//            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
//                    .getLayoutParams();
//            final int top = child.getBottom() + params.bottomMargin;
//            final int bottom = top + mDivider.getIntrinsicHeight();
//            mDivider.setBounds(left, top, right, bottom);
//            mDivider.draw(c);
//        }
//    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e("Activity","onStop");
    }

    private void checkPer() {
        Intent  intent=new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        startActivityForResult(intent, 231);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 231) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "权限授予失败，无法开启悬浮窗", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "权限授予成功！", Toast.LENGTH_SHORT).show();
                    //有悬浮窗权限开启服务绑定 绑定权限
//                    Intent intent = new Intent(MainActivity.this, MyService.class);
//                    startService(intent);
                    initWindow();
                }
        }

    }

    public static void permissionApplyInternal(Context context) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = Settings.class;
        Field field = clazz.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION");

        Intent intent = new Intent(field.get(null).toString());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 321){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {



            }
        }
    }

    private void initWindow() {
//        int i  = ContextCompat.checkSelfPermission(this,"android.permission.SYSTEM_ALERT_WINDOW");
//        if (i != PackageManager.PERMISSION_GRANTED){
//            //没有权限
//            Log.e("MainActivity","i="+i);
//            ActivityCompat.requestPermissions(this,new String[]{"android.permission.SYSTEM_ALERT_WINDOW"},321);
//        }


        WindowManager wManager = (WindowManager) getApplicationContext().getSystemService(
                Context.WINDOW_SERVICE);
        WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
//        mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;// 系统提示window
        mParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        mParams.format = PixelFormat.TRANSLUCENT;// 支持透明
        //mParams.format = PixelFormat.RGBA_8888;
        mParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;// 焦点
        mParams.width = 490;//窗口的宽和高
        mParams.height = 160;
        mParams.x = 0;//窗口位置的偏移量
        mParams.y = 0;
        //mParams.alpha = 0.1f;//窗口的透明度

        TextView tv = new TextView(this);
        tv.setBackgroundResource(R.color.colorPrimary);
        tv.setText("我是文本");
        wManager.addView(tv, mParams);//添加窗口


        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };


    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.e("statictest","onResume "+ImmersiveActivity.testStr);

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        Log.e("statictest","onResumeFragments "+ImmersiveActivity.testStr);

    }

    public void toimmer(View view) {
        Intent intent = new Intent(MainActivity.this,ImmersiveActivity.class);
        startActivity(intent);
    }

    public void toWebView(View view) {
        Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
        startActivity(intent);


    }
}
