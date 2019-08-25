package com.worker8.imgurgiraffe.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_oauth_login.*


class OAuthLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oauth_login)
        setupColors()
        setupWebView()
    }

    private fun setupWebView() {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (url.contains(Callback)) {
                    webViewLoading.visibility = View.GONE
                    val response = ImgurLoginExtrator.processUrl(url)
                    val intent = Intent().apply {
                        putExtra("access_token", response.accessToken)
                        putExtra("expires_in", response.expiresIn)
                        putExtra("token_type", response.tokenType)
                        putExtra("refresh_token", response.refreshToken)
                        putExtra("account_username", response.accountUsername)
                        putExtra("account_id", response.accountId)
                    }

                    setResult(Activity.RESULT_OK, intent)
                    finish()
                    // TODO: handle no network
                    // TODO: handle case of cancel or failure
                } else {
                    view.loadUrl(url)
                }
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                webViewLoading.visibility = View.GONE
            }
        }
        webView.setBackgroundColor(Color.BLACK)

        webView.settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
        }

        webView.loadUrl(OAuthUrl)
    }

    private fun setupColors() {
        window.setNavigationBarColor(Color.BLACK)
        window.statusBarColor = Color.BLACK
        supportActionBar?.hide()
    }
}




