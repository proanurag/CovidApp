package com.anurag.covidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.anurag.covidapp.R
import com.google.firebase.firestore.FirebaseFirestore

class BedsGetLocation : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    lateinit var autotext: AutoCompleteTextView
    lateinit var fstore: FirebaseFirestore
    lateinit var string: String
    lateinit var btnbedcity: Button
    private var arrayList: ArrayList<String>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beds_get_location)
        toolbar = findViewById(R.id.toolbar)
        fstore = FirebaseFirestore.getInstance()
        autotext = findViewById(R.id.etBedsLocation)
        btnbedcity=findViewById(R.id.btnBedCity)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Beds"
        fstore.collection("Beds").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                var i = 0
                for (document in task.result!!) {
                    string = document.id
                    arrayList?.add(string)
                    i += 1
                }
            }


            val arrayAdapter: ArrayAdapter<String> =
                ArrayAdapter(this, R.layout.single_row_element, arrayList!!)
            autotext.setAdapter(arrayAdapter)

        }
        btnbedcity.setOnClickListener {
            val intent = Intent(this,BedsDisplayDetails::class.java)
            intent.putExtra("cityname",autotext.text.toString())
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home){
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()}
        return super.onOptionsItemSelected(item)
    }
}