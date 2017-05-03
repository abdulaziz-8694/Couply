package com.example.a8aa8a.couply.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a8aa8a.couply.R;
import com.example.a8aa8a.couply.Utils.UrlUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button myntraButton;
    private Button jabongButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myntraButton = (Button) findViewById(R.id.myntra_button);
        jabongButton = (Button) findViewById(R.id.jabong_button);
        myntraButton.setOnClickListener(this);
        jabongButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent webViewIntent = new Intent(this, ShopWebViewActivity.class);
        if(v.getId() == R.id.myntra_button) {
            webViewIntent.putExtra(ShopWebViewActivity.BUNDLE_URL, UrlUtils.MYNTRA_URL);
        }else if(v.getId() == R.id.jabong_button) {
            webViewIntent.putExtra(ShopWebViewActivity.BUNDLE_URL, UrlUtils.JABONG_URL);
        }
        startActivity(webViewIntent);
    }
}
