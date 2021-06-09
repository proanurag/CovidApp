package com.anurag.covidapp.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anurag.covidapp.R
import com.anurag.covidapp.adapter.CitiesAdapter
import com.anurag.covidapp.adapter.OxygenAdapter
import com.anurag.covidapp.model.OxygenData
import com.google.firebase.firestore.FirebaseFirestore

class OxygenDisplayDetails : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var fstore: FirebaseFirestore
    lateinit var recyclerView: RecyclerView
    lateinit var city: String
    lateinit var contact:String
    var itemlist= arrayListOf<OxygenData>()
    lateinit var linearlayoutManager: LinearLayoutManager
    lateinit var recyclerAdapter: OxygenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oxygen_display_details)
        toolbar = findViewById(R.id.toolbar)
        fstore= FirebaseFirestore.getInstance()
        recyclerView = findViewById(R.id.recyclerViewOxygenData)
        linearlayoutManager = LinearLayoutManager(this)
        if (intent != null)
            city = intent.getStringExtra("cityname").toString()
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Oxygen Suppliers"
        fstore.collection("Oxygen").document(city).collection(city).get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful)
                    for (document in task.result!!)
                    {
                        fstore.collection("Oxygen").document(city).collection(city).document(document.id).addSnapshotListener{value,error->
                            if (error!=null)
                            {}


                            val obj=OxygenData(document.id,value?.getString("Contact").toString())
                            Log.d("objvalue",document.id)
                            itemlist.add(obj)
                            recyclerAdapter = OxygenAdapter(this, itemlist)
                            recyclerView.adapter = recyclerAdapter
                            recyclerView.layoutManager = linearlayoutManager
                        }
                    }
            }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, OxygenGetLocation::class.java))
        finish()
        super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            startActivity(Intent(this, OxygenGetLocation::class.java))
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}