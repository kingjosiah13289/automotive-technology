package com.example.automotivetech


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView

class NtsawebsiteActivity : AppCompatActivity() {
    lateinit var myweb : WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ntsawebsite)
        myweb = findViewById(R.id.websitentsa)
        var webSettings = myweb.settings
        webSettings.javaScriptEnabled=true
        myweb.loadUrl("https://www.tuko.co.ke/265837-how-register-ntsa-tims-account.html")
    }
}