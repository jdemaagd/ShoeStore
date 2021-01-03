package com.jdemaagd.shoestore.screens.shoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.models.Shoe

class ShoeAdapter(private var shoesList: MutableList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shoe_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = shoesList[position]
        holder.shoeName.text = shoe.name
        holder.shoeSize.text = shoe.size
        holder.company.text = shoe.company
        holder.description.text = shoe.description
    }

    override fun getItemCount(): Int {
        return shoesList.size
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val shoeName: TextView = item.findViewById(R.id.shoe_name)
        val shoeSize: TextView = item.findViewById(R.id.shoe_size)
        val company: TextView = item.findViewById(R.id.company_name)
        val description: TextView = item.findViewById(R.id.shoe_description)
    }
}