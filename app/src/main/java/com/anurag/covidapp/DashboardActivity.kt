package com.anurag.covidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.anurag.covidapp.R.layout.dashboard
import com.google.android.material.card.MaterialCardView
import com.google.android.material.navigation.NavigationView

class DashboardActivity : AppCompatActivity() {
    lateinit var toolbar:Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var oxygenreq:MaterialCardView
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var navigationView: NavigationView
    lateinit var medicinereq:MaterialCardView
    lateinit var ambulancereq:MaterialCardView
    lateinit var plasmareq:MaterialCardView
    lateinit var bedsreq:MaterialCardView
    lateinit var mealsreq:MaterialCardView
    lateinit var covidtestreq:MaterialCardView
    lateinit var helplinereq:MaterialCardView
    lateinit var miscreq:MaterialCardView
    lateinit var btntakeover:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(dashboard)
        toolbar=findViewById(R.id.toolbar)
        drawerLayout=findViewById(R.id.drawerLayout)
        oxygenreq=findViewById(R.id.oxygenRequirement)
        ambulancereq=findViewById(R.id.ambulanceReq)
        medicinereq=findViewById(R.id.medicineReq)
        plasmareq=findViewById(R.id.plasmaReq)
        bedsreq=findViewById(R.id.bedsReq)
        btntakeover=findViewById(R.id.takeOver)
        mealsreq=findViewById(R.id.mealsReq)
        covidtestreq=findViewById(R.id.covidTestReq)
        helplinereq=findViewById(R.id.helplineReq)
        miscreq=findViewById(R.id.miscReq)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        navigationView=findViewById(R.id.navigationView)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Home"
        val actionBarDrawerToggle=ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        oxygenreq.setOnClickListener {
            startActivity(Intent(this,OxygenGetLocation::class.java))
            finish()
        }
        medicinereq.setOnClickListener {
            startActivity(Intent(this,MedicineGetLocation::class.java))
            finish()
        }
        ambulancereq.setOnClickListener {
            startActivity(Intent(this,AmbulanceGetLocation::class.java))
            finish()
        }
        plasmareq.setOnClickListener {
            startActivity(Intent(this,PlasmaGetLocation::class.java))
            finish()
        }
        bedsreq.setOnClickListener {
            startActivity(Intent(this,BedsGetLocation::class.java))
            finish()
        }
        mealsreq.setOnClickListener {
            startActivity(Intent(this,MealsGetLocation::class.java))
            finish()
        }
        covidtestreq.setOnClickListener {
            startActivity(Intent(this,CovidTestGetLocation::class.java))
            finish()
        }
        helplinereq.setOnClickListener {
            startActivity(Intent(this,HelplineGetLocation::class.java))
            finish()
        }
        miscreq.setOnClickListener {
            startActivity(Intent(this,MiscGetLocation::class.java))
            finish()
        }
        btntakeover.setOnClickListener {
            startActivity(Intent(this,Cities::class.java))
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id =item.itemId
        if (id==android.R.id.home)
            drawerLayout.openDrawer(GravityCompat.START)
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}