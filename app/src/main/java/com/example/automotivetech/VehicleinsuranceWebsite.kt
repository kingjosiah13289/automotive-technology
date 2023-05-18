package com.example.automotivetech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class VehicleinsuranceWebsite : AppCompatActivity() {
    lateinit var insurewebsite : WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicleinsurance_website)
        insurewebsite = findViewById(R.id.insurewebsite)
        var webSettings = insurewebsite.settings
        webSettings.javaScriptEnabled=true
        insurewebsite.loadUrl("https://www.apainsurance.org/product_detail_motor.php")
    }
}