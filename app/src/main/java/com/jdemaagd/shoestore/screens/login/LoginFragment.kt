package com.jdemaagd.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentLoginBinding

import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        // Note: leverage Navigation via graph to find correct destination to
        binding.btnCreate.setOnClickListener { view ->
            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            } else {
                Toast.makeText(context, getString(R.string.no_auth), Toast.LENGTH_SHORT).show()
            }
        }

        // Note: leverage Navigation via graph to find correct destination to
        binding.btnLogin.setOnClickListener { view ->
            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            } else {
                Toast.makeText(context, getString(R.string.no_auth), Toast.LENGTH_SHORT).show()
            }
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login)

        return binding.root
    }

    fun authenticated(): Boolean {
        Timber.i("Fake Authentication!")

        // Note: only validating email/password are not empty
        return !binding.etEmail.text.isNullOrEmpty() &&
                !binding.etPassword.text.isNullOrEmpty()
    }
}