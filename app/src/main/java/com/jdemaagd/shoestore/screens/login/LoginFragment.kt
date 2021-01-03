package com.jdemaagd.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.jdemaagd.shoestore.R
import com.jdemaagd.shoestore.databinding.FragmentLoginBinding
import com.jdemaagd.shoestore.models.User

import timber.log.Timber

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.i("Fragment Lifecycle onCreateView: inflate view and handle bindings.")

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.login)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i("Fragment Lifecycle onViewCreated: " +
                "Fragment View has been instantiated so handle LifecycleOwner ")

        // Note: create ViewModel and associate to this Fragment
        //       also handles configuration changes such as device rotation
        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        // Note: setup binding for LiveData to know to observe this LifecycleOwner
        binding.lifecycleOwner = this

        // Note: leverage Navigation via graph to find correct destination to
        binding.btnCreate.setOnClickListener { view ->
            setUser()

            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            } else {
                Toast.makeText(context, getString(R.string.no_auth),
                    Toast.LENGTH_SHORT).show()
            }
        }

        // Note: leverage Navigation via graph to find correct destination to
        binding.btnLogin.setOnClickListener { view ->
            setUser()

            if (authenticated()) {
                view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
            } else {
                Toast.makeText(context, getString(R.string.no_auth),
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun authenticated(): Boolean {
        Timber.i("Fake Authentication!")

        // Note: only validating email/password are not empty
        return !binding.user?.email?.isNullOrEmpty()!! &&
                !binding.user?.password?.isNullOrEmpty()!!
    }

    private fun setUser() {
        binding.user = User(binding.etEmail.text.toString(),
            binding.etPassword.text.toString())
    }
}