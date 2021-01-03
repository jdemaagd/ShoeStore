package com.jdemaagd.shoestore.screens.shoe

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentShoeCollectionBinding

class ShoeCollectionFragment : Fragment() {

    private lateinit var binding: FragmentShoeCollectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_collection, container, false)

        // Note: let Android know a menu is associated with this Fragment
        setHasOptionsMenu(true)

        binding.fabAddShoe.setOnClickListener { view ->
            view.findNavController().navigate(ShoeCollectionFragmentDirections.actionShoeListToShoeDetails())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(ShoeDetailsViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, { list ->
            val adapter = ShoeAdapter(list)
            binding.rvShoes.adapter = adapter
        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.collection_title)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}