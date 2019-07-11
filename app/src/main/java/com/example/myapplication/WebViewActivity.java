package com.example.myapplication;

import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = findViewById(R.id.wv);

        TextView tv = findViewById(R.id.tv);
        tv.setTextIsSelectable(true);

        tv.setText("http://10.201.56.99:3000/pages/chooselesson-classdetail/chooselesson-classdetail.html?schoolId=1&classCode=PP01");

        webView.loadUrl("http://10.201.56.99:3000/pages/chooselesson-classdetail/chooselesson-classdetail.html?schoolId=1&classCode=PP01");



        WebSettings wetSettings = webView.getSettings();
        wetSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wetSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedError(WebView view, int errorCode, String description,
                                        String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);

                if(failingUrl.contains(".html")) {

                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }
        });

    }
}
