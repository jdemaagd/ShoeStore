package com.jdemaagd.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentShoeDetailsBinding
import com.jdemaagd.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {

    lateinit var viewModel: ShoeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ShoeDetailsViewModel::class.java)

        binding.lifecycleOwner = this
        binding.save.setOnClickListener {

            binding.shoe = Shoe(
                binding.shoeName.text.toString(),
                binding.shoeSize.text.toString(),
                binding.companyName.text.toString(),
                binding.shoeDescription.text.toString()
            )

            val s = binding.shoe
            viewModel.saveCurrentDetail(s)
            view?.findNavController()?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeList())
        }

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeList())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.add_shoe_details)

        return binding.root
    }
}