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

class MedicineGetLocation : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    lateinit var autotext: AutoCompleteTextView
    lateinit var fstoremed: FirebaseFirestore
    lateinit var stringmed: String
    lateinit var btnmedcitylocation: Button
    private var arrayList: ArrayList<String>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine_get_location)
        toolbar = findViewById(R.id.toolbar)
        fstoremed = FirebaseFirestore.getInstance()
        autotext = findViewById(R.id.etMedicineLocation)
        btnmedcitylocation=findViewById(R.id.btnMedCity)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Medicine"
        fstoremed.collection("Medicine").get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                var i = 0
                for (document in task.result!!) {
                    stringmed = document.id
                    arrayList?.add(stringmed)
                    i += 1
                }
            }


            val arrayAdapter: ArrayAdapter<String> =
                ArrayAdapter(this, R.layout.single_row_element, arrayList!!)
            autotext.setAdapter(arrayAdapter)

        }
        btnmedcitylocation.setOnClickListener {
            val intent = Intent(this,MedicineDisplayDetails::class.java)
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
        val id=item.itemId
        if (id==android.R.id.home){
            startActivity(Intent(this, DashboardActivity::class.java))
        finish()}
        return super.onOptionsItemSelected(item)
    }
}