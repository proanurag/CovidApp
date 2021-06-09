package com.anurag.covidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.anurag.covidapp.model.CitiesData
import com.anurag.covidapp.R

class CitiesAdapter(val context: Context, private var itemlist: ArrayList<CitiesData>) :
    RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {
    class CitiesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val btncities:Button=view.findViewById(R.id.btnCities)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.single_row_element2, parent, false)
        return CitiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val list = itemlist[position]
        holder.btncities.text=list.btncity
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

}