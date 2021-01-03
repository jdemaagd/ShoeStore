package com.jdemaagd.shoestore.screens.shoe

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    init {
        Timber.i("Shoe List")
    }

    // Note: callback before ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
        Timber.i("Destroyed!")
    }
}