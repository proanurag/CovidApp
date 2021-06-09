package com.anurag.covidapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anurag.covidapp.R
import com.anurag.covidapp.model.OxygenData

class OxygenAdapter(val context: Context,val item:ArrayList<OxygenData>):RecyclerView.Adapter<OxygenAdapter.OxygenViewHolder>() {
    class OxygenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name:TextView=view.findViewById(R.id.four)
        val contact:TextView=view.findViewById(R.id.five)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OxygenViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.single_row_details, parent, false)
        return OxygenViewHolder(view)
    }


    override fun onBindViewHolder(holder: OxygenViewHolder, position: Int) {
        val list=item[position]
        holder.name.text=list.supp
        holder.contact.text=list.con
    }

    override fun getItemCount(): Int {
        return item.size-1
    }
}