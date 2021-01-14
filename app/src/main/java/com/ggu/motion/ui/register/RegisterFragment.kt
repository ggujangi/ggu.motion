package com.ggu.motion.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ggu.motion.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.submit.setOnClickListener {
            val data: String = binding.input.text.toString()
            val action = RegisterFragmentDirections
                .actionNavRegisterToNavResult(data)

            findNavController().navigate(action)
        }

        return binding.root
    }
}