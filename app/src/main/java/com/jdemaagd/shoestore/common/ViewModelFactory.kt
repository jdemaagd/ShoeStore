package com.jdemaagd.shoestore.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Note: create custom ViewModel(s)
class ViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        // TODO: return correct ViewModel(s)

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}