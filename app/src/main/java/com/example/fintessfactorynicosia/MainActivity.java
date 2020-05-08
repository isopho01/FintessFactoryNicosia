package com.example.fintessfactorynicosia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private long backPressedTime = 0;    // used by onBackPressed()


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button home = findViewById(R.id.home);
        final Button login = findViewById(R.id.login);
        final ImageView logo = findViewById(R.id.imageView5);
        final Button classes = findViewById(R.id.classes);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView = (WebView) findViewById(R.id.webview);
                webView.loadUrl("javascript:document.open();document.close();");
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("http://ffnfinal.web.app/");
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);
                login.setVisibility(View.INVISIBLE);
                home.setVisibility(View.INVISIBLE);
                logo.setVisibility(View.INVISIBLE);
                classes.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView = (WebView) findViewById(R.id.webview);
                webView.loadUrl("javascript:document.open();document.close();");

                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("http://ffnfinal.web.app/loginAndroid");
                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);
                login.setVisibility(View.INVISIBLE);
                home.setVisibility(View.INVISIBLE);
                logo.setVisibility(View.INVISIBLE);
                classes.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);


            }
        });
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView = (WebView) findViewById(R.id.webview);
                webView.loadUrl("javascript:document.open();document.close();");

                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("http://ffnfinal.web.app/classes");

                WebSettings webSettings = webView.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setSupportZoom(true);
                webSettings.setLoadWithOverviewMode(true);
                webSettings.setUseWideViewPort(true);

                login.setVisibility(View.INVISIBLE);
                home.setVisibility(View.INVISIBLE);
                logo.setVisibility(View.INVISIBLE);
                classes.setVisibility(View.INVISIBLE);
                webView.setVisibility(View.VISIBLE);


            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onBackPressed() {
        final Button home = findViewById(R.id.home);
        final Button login = findViewById(R.id.login);
        final ImageView logo = findViewById(R.id.imageView5);
        final Button classes = findViewById(R.id.classes);
        if (webView.canGoBack()) {
            Log.d("URL", webView.getUrl());

            login.setVisibility(View.VISIBLE);
            home.setVisibility(View.VISIBLE);
            logo.setVisibility(View.VISIBLE);
            classes.setVisibility(View.VISIBLE);
            webView.setVisibility(View.INVISIBLE);
        } else {

            if (!webView.canGoBack() && webView.getVisibility() == View.VISIBLE) {
                login.setVisibility(View.VISIBLE);
                home.setVisibility(View.VISIBLE);
                logo.setVisibility(View.VISIBLE);
                classes.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);
            } else {
//                super.onBackPressed();
                long t = System.currentTimeMillis();
                if (t - backPressedTime > 2000) {    // 2 secs
                    backPressedTime = t;
                    Toast.makeText(this, "Press back again to exit the app",
                            Toast.LENGTH_SHORT).show();
                } else {    // this guy is serious
                    // clean up
                    super.onBackPressed();       // bye
                }
            }
        }
    }
}