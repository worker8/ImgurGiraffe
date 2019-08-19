package com.worker8.imgurgiraffe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {
    val RC_SIGN_IN = 23828;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //intent.data.fragment.split("&")
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                Log.d("ddw", "opening url: ${url}")
                if (!url.contains("https://imgurgiraffe.com/callback")) {
                    view.loadUrl(url)
                } else {
                    Log.d("ddw", "url: ${url}")
                    val intent = Intent(this@MainActivity, DeepLinkActivity::class.java)
                    intent.putExtra("received_url", url)
                    startActivity(intent)
                    finish()
                }
                return true
            }
        }
        webView.settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
        }

        webView.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=354420e933534e4&client_secret=a4b90b16a4b90b16a6dc38196f15151a4a8e0f25de969030a6dc38196f15151a4a8e0f25de969030&grant_type=refresh_token&response_type=token")
    }
}
