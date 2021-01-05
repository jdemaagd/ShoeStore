package com.jdemaagd.shoestore.screens.shoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.ShoeItemBinding
import com.jdemaagd.shoestore.models.Shoe

// Note: bridge between RecyclerView and the View data (shoe_item)
class ShoeAdapter(private var shoes: MutableList<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    private lateinit var binding: ShoeItemBinding

    // Note: handles layout inflation and returns view-holder requested by RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.shoe_item, parent, false)

//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.shoe_item, parent, false)

        return ViewHolder(binding.root)
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
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val company: TextView = view.findViewById(R.id.tv_company)
        val description: TextView = view.findViewById(R.id.tv_description)
        val shoeName: TextView = view.findViewById(R.id.tv_name)
        val shoeSize: TextView = view.findViewById(R.id.tv_size)
    }
}