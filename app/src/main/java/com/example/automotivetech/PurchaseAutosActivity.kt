package com.example.automotivetech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PurchaseAutosActivity : AppCompatActivity() {
    lateinit var nexts : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase_autos)
        nexts = findViewById(R.id.btn_sparepartsnext)
        nexts.setOnClickListener {
            var enda = Intent(this, SparepartsWebsite::class.java)
            startActivity(enda)
        }
    }
}