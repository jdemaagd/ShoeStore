package com.jdemaagd.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentInstructionBinding

import timber.log.Timber

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false)

        // Note: leverage Navigation via graph to find correct destination to
        binding.btnShoes.setOnClickListener { view ->
            view.findNavController().navigate(InstructionFragmentDirections.actionInstructionToShoeList())
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.instruction)

        return binding.root
    }
}