package com.example.library.util;

import android.os.Environment;

public class Constants {

    /**
     * Log日志Tag日志前缀名
     */
    public static final String LOG_TAG = "mhw.image >>> ";

    /**
     * SD卡详细路径
     */
    private static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();

    /**
     * 图片缓存路径
     */
    public static String IMAGES_DIR_ROOT = SDCARD_ROOT + "/Android/data/";

    /**
     * 保存图片缓存路径
     */
    public static final String IMAGE_CACHE_DIR = "/images/images_cache";
}
