package com.jdemaagd.shoestore.screens.shoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentShoeDetailsBinding
import com.jdemaagd.shoestore.models.Shoe

import timber.log.Timber

class ShoeDetailsFragment : Fragment() {

    private lateinit var shoeDetailsViewModel: ShoeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater, R.layout.fragment_shoe_details, container, false)

        // Note: create ViewModel and associate to this Fragment
        //       also handles configuration changes such as device rotation
        shoeDetailsViewModel = ViewModelProvider(requireActivity()).get(ShoeDetailsViewModel::class.java)

        // Note: setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        binding.btnSave.setOnClickListener { view ->
            binding.shoe = Shoe(
                binding.etShoeName.text.toString(),
                binding.etShoeSize.text.toString(),
                binding.etCompanyName.text.toString(),
                binding.etDescription.text.toString()
            )

            val shoe = binding.shoe

            shoeDetailsViewModel.saveCurrentDetail(shoe)

            // Note: leverage Navigation via graph to find correct destination to
            //       popTo: shoe_list (non-inclusive)
            view?.findNavController()
                ?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeList())
        }

        // Note: leverage Navigation via graph to find correct destination to
        //       popTo: shoe_list (non-inclusive)
        binding.btnCancel.setOnClickListener { view ->
            view?.findNavController()?.navigate(ShoeDetailsFragmentDirections.actionShoeDetailsToShoeList())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.shoe_details)

        return binding.root
    }
}