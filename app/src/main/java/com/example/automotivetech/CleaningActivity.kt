package com.example.automotivetech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CleaningActivity : AppCompatActivity() {
    lateinit var next : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cleaning)
        next = findViewById(R.id.btn_washprocede)
        next.setOnClickListener {
            var enda = Intent(this, CleaningTwoActivity::class.java)
            startActivity(enda)
        }
    }
}