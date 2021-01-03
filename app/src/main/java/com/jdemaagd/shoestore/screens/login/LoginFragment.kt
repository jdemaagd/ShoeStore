package com.jdemaagd.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        binding.btnCreate.setOnClickListener { view ->
            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
        }

        binding.btnLogin.setOnClickListener { view ->
            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
        }

        return binding.root
    }

    fun authenticated(): Boolean {
        // Note: only validating email/password are not empty
        return !binding.etEmail.text.isNullOrEmpty() &&
                !binding.etPassword.text.isNullOrEmpty()
    }
}