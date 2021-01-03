package com.jdemaagd.shoestore.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jdemaagd.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailsViewModel : ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    init {
        Timber.i("Shoe List")
    }

    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    // Note: callback before ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
        Timber.i("Destroyed!")
    }

    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }
}