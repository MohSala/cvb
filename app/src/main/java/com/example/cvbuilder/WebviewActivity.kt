package com.example.cvbuilder

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        val intent = intent
        val url = intent.getStringExtra("url").toString()
        var webview = findViewById<WebView>(R.id.webview)
        val webSettings: WebSettings = webview.settings
        webSettings.javaScriptEnabled = true
        webview.loadUrl(url);

    }
}