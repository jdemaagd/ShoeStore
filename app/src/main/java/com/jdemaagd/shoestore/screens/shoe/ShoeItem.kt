package com.jdemaagd.shoestore.screens.shoe

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

import androidx.databinding.DataBindingUtil

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.ShoeItemBinding
import com.jdemaagd.shoestore.models.Shoe

class ShoeItem: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ShoeItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context), R.layout.shoe_item, this, false)

    fun loadShoe(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            tvName.text = shoe.name
            tvCompany.text = shoe.company
            tvSize.text = shoe.size
            tvDescription.text = shoe.description
        }
    }
}