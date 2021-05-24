package com.anurag.covidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Cities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
    }
    override fun onBackPressed() {
        startActivity(Intent(this,DashboardActivity::class.java))
        finish()
        super.onBackPressed()
    }
}