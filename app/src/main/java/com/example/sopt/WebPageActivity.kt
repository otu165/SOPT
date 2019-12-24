package com.example.sopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class WebPageActivity : AppCompatActivity() {
    private lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_page)

        webPageFunction()
    }

    private fun webPageFunction() {
        webView = findViewById(R.id.webView)

        //새 창이 뜨는 것 방지
        webView.webViewClient = WebViewClient()

        //웹 환경설정
        var webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        //화면 비율
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true

        //줌(zoom)
        webSettings.builtInZoomControls = true
        webSettings.setSupportZoom(true)

        webView.loadUrl("https://comic.naver.com/index.nhn")
    }
}
