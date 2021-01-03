package com.jdemaagd.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.jdemaagd.shoestore.models.User

import timber.log.Timber

class LoginViewModel : ViewModel() {

    // Note: mutable LiveData for internal access
    private val _user = MutableLiveData<User>()

    init {
        Timber.i("ViewModel Lifecycle started.")
    }

    // Note: expose LiveData (non-mutable)
    val user: LiveData<User>
        get() = _user

    // Note: callback before ViewModel is destroyed
    override fun onCleared() {
        super.onCleared()
        Timber.i("ViewModel Lifecycle Destroyed!")
    }
}