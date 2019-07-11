package com.example.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityController {

    private List<Activity> mActivities;
    private volatile static ActivityController instance;
    private ActivityController(){

        mActivities = new CopyOnWriteArrayList<>();
    }
    public static ActivityController getInstance(){
        if (instance == null){

            synchronized (ActivityController.class){
                if (instance == null){
                    instance = new ActivityController();
                }
            }
        }
        return instance;
    }

    private static class ActivityControllerHolder{
        private static ActivityController instance = new ActivityController();
    }

    public static ActivityController getIns(){
        return ActivityControllerHolder.instance;
    }

    /**
     * 只允许同包下调用
     *
     * @param pActivity
     */
    public void add(Activity pActivity) {
        if (mActivities != null && pActivity != null) {
            mActivities.add(pActivity);
        }
    }

    public void remove(Activity pActivity) {
        if (mActivities != null) {
            pActivity.finish();
            mActivities.remove(pActivity);
        }
    }



}
