package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AutoserviceActivity : AppCompatActivity() {
    lateinit var oilchange : Button
    lateinit var wipers : Button
    lateinit var newtyres : Button
    lateinit var battery : Button
    lateinit var brakes : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autoservice)
        oilchange = findViewById(R.id.btn_oilChange)
        wipers = findViewById(R.id.btn_wiperblades)
        newtyres = findViewById(R.id.btn_newtyres)
        battery = findViewById(R.id.btn_batteryreplacement)
        brakes = findViewById(R.id.btn_brakework)


    }
}