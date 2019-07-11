package com.example.library.cache;

import android.graphics.Bitmap;

import com.example.library.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface DiskCache {


    File get(String imageUri);

    boolean save(String imageUri, InputStream imageStream, IOUtils.CopyListener listener) throws IOException;

    void save(String imageUri, Bitmap bitmap) throws IOException;

    void close();

    void clear();

}
