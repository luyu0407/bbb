package com.example.myapplication.util;

import android.app.Activity;
import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;

public class DensityUtil {

    private static final float  WIDTH = 320;//参考设备的宽
    private static float appDensity;//表示屏幕密度
    private static float appScaleDensity; //字体缩放比例，默认appDensity

    public static void setDensity(Application application, Activity activity){

        DisplayMetrics appMetrics = application.getResources().getDisplayMetrics();
        Log.d("density","appMetrics.density = "+appMetrics.density);
        Log.d("density","appMetrics.widthPixels = "+appMetrics.widthPixels);

        if (appDensity == 0){
            //获得系统默认
            appDensity = appMetrics.density;
            appScaleDensity = appMetrics.scaledDensity;
        }

        //计算目标值
        float targetDensity = appMetrics.widthPixels/WIDTH;
        float targetScaleDensity = (appScaleDensity/appDensity)*targetDensity;
        int targetDensityDpi = (int) (targetDensity * 160);

        //替换density，scaledDensity，densityDpi值
        DisplayMetrics activityMetrics = activity.getResources().getDisplayMetrics();
        activityMetrics.density = targetDensity;
        activityMetrics.scaledDensity = targetScaleDensity;
        activityMetrics.densityDpi = targetDensityDpi;

        Log.d("density","targetDensity = "+targetDensity);

        Log.d("density","appMetrics.density = "+appMetrics.density);
        Log.d("density","activityMetrics.density = "+activityMetrics.density);

    }
}
