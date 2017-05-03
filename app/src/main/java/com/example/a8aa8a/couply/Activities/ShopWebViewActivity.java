package com.example.a8aa8a.couply.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.a8aa8a.couply.R;

public class ShopWebViewActivity extends AppCompatActivity {
    public static final String BUNDLE_URL = "bundle_url";
    private Intent intent;
    private String URL;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_web_view);
        initControls();
        intent = getIntent();
        if(intent!=null){
            URL = intent.getExtras().getString(ShopWebViewActivity.BUNDLE_URL);
            webView.loadUrl(URL);
        }
    }

    private void initControls() {
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
    }
}
