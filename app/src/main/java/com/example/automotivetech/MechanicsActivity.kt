package com.example.automotivetech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MechanicsActivity : AppCompatActivity() {
    lateinit var mechanics : WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanics)
        mechanics = findViewById(R.id.mechanicsweb)
        var webSettings = mechanics.settings
        webSettings.javaScriptEnabled=true
        mechanics.loadUrl("https://www.automotive-doctor.co.ke/")
    }
}