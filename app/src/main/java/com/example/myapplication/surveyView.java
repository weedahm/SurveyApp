package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class surveyView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);

        String url = "https://docs.google.com/forms/d/e/1FAIpQLSfX3ej4QJzt1a8a7_TtIsN2aICC4nizamth2J7NzccKgh1uHw/viewform";
        WebView webView =(WebView) findViewById(R.id.survey);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);
    }

}