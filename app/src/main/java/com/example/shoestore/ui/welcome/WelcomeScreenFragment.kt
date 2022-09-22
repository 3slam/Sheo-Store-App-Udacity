package com.example.shoestore.ui.welcome
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeScreenBinding


class WelcomeScreenFragment : Fragment() {

    lateinit var binding: FragmentWelcomeScreenBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextOne.setOnClickListener {
            var action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionFragment()
            findNavController().navigate(action)
        }
    }
}