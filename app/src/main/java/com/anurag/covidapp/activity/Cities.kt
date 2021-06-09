package com.anurag.covidapp.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anurag.covidapp.adapter.CitiesAdapter
import com.anurag.covidapp.model.CitiesData
import com.anurag.covidapp.R
import com.google.firebase.firestore.FirebaseFirestore

class Cities : AppCompatActivity() {
    lateinit var fstore: FirebaseFirestore
    lateinit var recyclerView: RecyclerView
    lateinit var linearlayoutManager: LinearLayoutManager
    lateinit var string2: String
    private var arrayList2: ArrayList<String>? = ArrayList()
    lateinit var toolbar: Toolbar
    val citiesinfo= arrayListOf<CitiesData>()
    lateinit var recyclerAdapter: CitiesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
        toolbar = findViewById(R.id.toolbar)
        recyclerView=findViewById(R.id.recyclerView)
        linearlayoutManager = LinearLayoutManager(this)
        fstore= FirebaseFirestore.getInstance()
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Cities"
        fstore.collection("Oxygen").get().addOnCompleteListener { task->
            if (task.isSuccessful) {
                var j = 0
                for (document in task.result!!) {
                    string2 = document.id
                    arrayList2?.add(string2)
                    j = j + 1
                }


                for (i in 0..arrayList2!!.size - 1) {
                    val obj = CitiesData(arrayList2!![i])
                    citiesinfo.add(obj)
                    recyclerAdapter = CitiesAdapter(this, citiesinfo)
                    recyclerView.adapter = recyclerAdapter
                    recyclerView.layoutManager = linearlayoutManager

                }
            }}
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