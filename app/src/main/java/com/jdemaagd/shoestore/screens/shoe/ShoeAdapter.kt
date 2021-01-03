package com.jdemaagd.shoestore.screens.shoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.models.Shoe

// Note: bridge between RecyclerView and the View data (shoe_item)
class ShoeAdapter(private var shoes: MutableList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    // Note: handles layout inflation and returns view-holder requested by RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shoe_item, parent, false)

        return ViewHolder(view)
    }

    // Note: responsible for binding view-holder given its position in RecyclerView
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = shoes[position]

        holder.company.text = shoe.company
        holder.description.text = shoe.description
        holder.shoeName.text = shoe.name
        holder.shoeSize.text = shoe.size
    }

    override fun getItemCount(): Int {
        return shoes.size
    }

    // Note: describes item (shoe) and metadata about its place (position) in RecyclerView
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val company: TextView = item.findViewById(R.id.tv_company_name)
        val description: TextView = item.findViewById(R.id.tv_shoe_description)
        val shoeName: TextView = item.findViewById(R.id.tv_shoe_name)
        val shoeSize: TextView = item.findViewById(R.id.tv_shoe_size)
    }
}