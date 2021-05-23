package com.anurag.covidapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class OxygenGetLocation : AppCompatActivity() {
    lateinit var autotext: AutoCompleteTextView
    private lateinit var toolbar: Toolbar
    private lateinit var arrayList:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oxygen_get_location)
        toolbar = findViewById(R.id.toolbar)
        autotext=findViewById(R.id.etOxygenLocation)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Oxygen"


    }


    override fun onBackPressed() {
        startActivity(Intent(this,DashboardActivity::class.java))
        finish()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==android.R.id.home){
            startActivity(Intent(this,DashboardActivity::class.java))
        finish()}
        return super.onOptionsItemSelected(item)
    }
}