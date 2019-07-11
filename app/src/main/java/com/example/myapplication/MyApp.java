package com.example.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        registerLifeCycle();
    }

    private void registerLifeCycle() {

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityController.getInstance().add(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityController.getInstance().remove(activity);
            }
        });

    }

}
