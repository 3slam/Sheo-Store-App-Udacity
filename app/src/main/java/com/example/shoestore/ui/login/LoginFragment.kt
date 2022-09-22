package com.example.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding
import com.example.shoestore.viewModels.ViewModelSheos


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: ViewModelSheos
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        viewModel = ViewModelProvider(this).get(ViewModelSheos::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signinBtn.setOnClickListener {
            var action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
            findNavController().navigate(action)

        }
            binding.signupBtn.setOnClickListener {
                var action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
                findNavController().navigate(action)
            }


        }
}