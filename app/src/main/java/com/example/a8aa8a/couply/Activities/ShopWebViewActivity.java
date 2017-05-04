package com.example.a8aa8a.couply.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.a8aa8a.couply.R;
import com.example.a8aa8a.couply.Utils.LogUtils;
import com.example.a8aa8a.couply.Utils.StringUtils;

public class ShopWebViewActivity extends AppCompatActivity {
    public static final String TAG  = "ShopWebView";
    public static final String BUNDLE_URL = "bundle_url";
    private Intent mIntent;
    private String mURL;
    WebView mWebView;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_web_view);
        initControls();
        mIntent = getIntent();
        if(mIntent !=null){
            mURL = mIntent.getExtras().getString(ShopWebViewActivity.BUNDLE_URL);
            if(!StringUtils.isEmptyString(mURL)) {
                mWebView.loadUrl(mURL);
            } else {
                finish();
            }

        }
    }

    private void initControls() {
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());
        mProgressBar = (ProgressBar) findViewById(R.id.webview_progress);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mWebView.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            mProgressBar.setVisibility(View.GONE);
            mWebView.setVisibility(View.VISIBLE);
            LogUtils.logDebug(ShopWebViewActivity.TAG, url);
        }
    }

    @Override
    public void onBackPressed(){
        if(mWebView.canGoBack()){
            mWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        public void onProgressChanged(WebView view, int newProgress) {
            mProgressBar.setProgress(newProgress);
        }
    }
}
