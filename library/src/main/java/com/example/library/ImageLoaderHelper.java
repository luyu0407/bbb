package com.example.library;

import android.widget.ImageView;

import com.example.library.core.ImageLoader;

public class ImageLoaderHelper {

    private ImageLoader imageLoader;
    private ImageView imageView;
    private String loadUrl;
    private ImageLoaderHelper(Builder builder){
        imageLoader = ImageLoader.getInstance();
        this.loadUrl = builder.loadUrl;
        this.imageView = builder.imageView;
        display();
    }

    private void display() {
        if (imageLoader!=null){
            imageLoader.displayImage(loadUrl,imageView);
        }
    }


    public Builder with(){
        return new Builder();
    }

    public class Builder{

        private ImageView imageView;
        private String loadUrl;

        public Builder from(String loadUrl){
            this.loadUrl = loadUrl;
            return this;
        }

        public Builder into(ImageView imageView){
            this.imageView = imageView;
            return this;
        }

        public void display(){
            new ImageLoaderHelper(this);
        }
    }
}
