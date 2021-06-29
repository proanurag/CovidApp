package com.anurag.covidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.anurag.covidapp.R

class MiscellaneousDisplayDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miscellaneous_display_details)
    }
    override fun onBackPressed() {
        startActivity(Intent(this, MiscGetLocation::class.java))
        finish()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==android.R.id.home){
            startActivity(Intent(this, MiscGetLocation::class.java))
            finish()}
        return super.onOptionsItemSelected(item)
    }
}