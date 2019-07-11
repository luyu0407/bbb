package com.example.library.core;


import android.util.Log;
import android.widget.ImageView;

import com.example.library.config.ImageLoaderConfiguration;
import com.example.library.util.Constants;

public class ImageLoader {

    private ImageLoaderConfiguration configuration; // 图片加载配置

    private volatile static ImageLoader instance;

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    /**
     *
     * @param configuration 配置初始化
     */
    public synchronized void init(ImageLoaderConfiguration configuration){
        if (configuration == null){
            throw new IllegalArgumentException("ImageLoader配置为空，不能初始化");
        }

        if (this.configuration == null){
            Log.e(Constants.LOG_TAG, "ImageLoader配置初始化");

            this.configuration = configuration;
        }else {
            Log.e(Constants.LOG_TAG, "ImageLoader已被初始化");
        }


    }

    /**
     * 显示图片
     * @param loadUrl
     * @param imageView
     */
    public void displayImage(String loadUrl, ImageView imageView) {



    }
}
