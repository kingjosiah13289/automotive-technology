package com.example.automotivetech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class SparepartsWebsite : AppCompatActivity() {
    lateinit var spares : WebView
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spareparts_website)
        spares = findViewById(R.id.spareparts)
        var webSettings = spares.settings
        webSettings.javaScriptEnabled=true
        spares.loadUrl("https://wholesaler.made-in-china.com/cheap/guangzhou-frey-auto-parts.html?acc=4444569729&cpn=20047618964-152394711510&tgt=kwd-414466635036&net=g&dev=c-&gid=Cj0KCQjwu-KiBhCsARIsAPztUF2dQft2U1aIf4-yk_TI-bbdkWbsUFS2n1Hlhgjtl_ce-gC01_RzF2kaAvqTEALw_wcB&kwd=car%20body%20replacement&mtp=b&gclid=Cj0KCQjwu-KiBhCsARIsAPztUF2dQft2U1aIf4-yk_TI-bbdkWbsUFS2n1Hlhgjtl_ce-gC01_RzF2kaAvqTEALw_wcB")

    }
}