package com.example.library.cache;

import android.graphics.Bitmap;

import com.example.library.cache.core.DiskLruCache;
import com.example.library.core.filename.FileNameGenerator;
import com.example.library.util.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class LruDiskCache implements DiskCache {

    private static final int DEFAULT_BUFFER_SIZE = 32 * 1024; // 32 Kb
    private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    private static final int DEFAULT_COMPRESS_QUALITY = 100;
    protected DiskLruCache cache;
    private int bufferSize = DEFAULT_BUFFER_SIZE;
    private Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
    private final FileNameGenerator fileNameGenerator ;
    private DiskLruCache.Snapshot snapshot;



    public LruDiskCache(File cacheDir, FileNameGenerator fileNameGenerator, long cacheMaxSize,
                        int cacheMaxFileCount) throws IOException {
        if (cacheDir == null) {
            throw new IllegalArgumentException("cacheDir参数不能为空");
        }
        if (cacheMaxSize < 0) {
            throw new IllegalArgumentException("cacheMaxSize参数必须为正数");
        }
        if (cacheMaxFileCount < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount参数必须为正数");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator参数不能为空");
        }

        if (cacheMaxSize == 0) {
            cacheMaxSize = Long.MAX_VALUE;
        }
        if (cacheMaxFileCount == 0) {
            cacheMaxFileCount = Integer.MAX_VALUE;
        }

        this.fileNameGenerator = fileNameGenerator;
        initCache(cacheDir, cacheMaxSize, cacheMaxFileCount);
    }

    private void initCache(File cacheDir, long cacheMaxSize, int cacheMaxFileCount)throws IOException{
        try {
            cache = DiskLruCache.open(cacheDir,1,1,cacheMaxSize,cacheMaxFileCount);
        } catch (IOException e) {
            e.printStackTrace();
            if (cache == null){
                throw e;
            }
        }
    }

    @Override
    public File get(String imageUri) {

        try {
            snapshot =cache.get(getKey(imageUri));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (snapshot!=null){
                snapshot.close();
            }
        }

        return null;
    }

    private String getKey(String imageUri) {
        return fileNameGenerator.generate(imageUri);
    }

    @Override
    public boolean save(String imageUri, InputStream imageStream, IOUtils.CopyListener listener) throws IOException {
        return false;
    }

    @Override
    public void save(String imageUri, Bitmap bitmap) throws IOException {

    }

    @Override
    public void close() {

    }

    @Override
    public void clear() {

    }
}
