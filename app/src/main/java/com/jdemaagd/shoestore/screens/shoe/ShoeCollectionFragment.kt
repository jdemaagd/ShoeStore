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

import timber.log.Timber

class ShoeCollectionFragment : Fragment() {

    private lateinit var binding: FragmentShoeCollectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_collection, container, false)

        // Note: let Android know a menu is associated with this Fragment
        setHasOptionsMenu(true)

        // Note: leverage Navigation via graph to find correct destination to
        binding.fabAddShoe.setOnClickListener { view ->
            view.findNavController().navigate(ShoeCollectionFragmentDirections.actionShoeListToShoeDetails())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i("Fragment Lifecycle onViewCreated: " +
                "Fragment View has been instantiated so handle LifecycleOwner ")

        // Note: create ViewModel and associate to this Fragment
        //       also handles configuration changes such as device rotation
        val showDetailsViewModel = ViewModelProvider(requireActivity())
            .get(ShoeDetailsViewModel::class.java)

        // Note: setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        // Note: ViewModel field(s) can now Observer Lifecycle changes
        showDetailsViewModel.shoes.observe(viewLifecycleOwner, { list ->
            val adapter = ShoeAdapter(list)
            binding.rvShoes.adapter = adapter
        })

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.collection_title)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    // Note: leveraging NavigationUI library to handle menu navigation
    //       requires matching ids in menu and in navigation graph
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}