package com.example.automotivetech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MaintainingActivity : AppCompatActivity() {
    lateinit var aircondition : Button
    lateinit var radiator : Button
    lateinit var headlights : Button
    lateinit var rotatetyres : Button
    lateinit var waxvehicle : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maintaining)
        aircondition = findViewById(R.id.btn_aircondition)
        radiator = findViewById(R.id.btn_radiatorcheck)
        headlights = findViewById(R.id.btn_headlights)
        rotatetyres = findViewById(R.id.btn_rotateTyre)
        waxvehicle = findViewById(R.id.btn_waxvehicle)

    }
}