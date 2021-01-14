package com.ggu.motion.ui.result

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ggu.motion.ViewModelFactory
import com.ggu.motion.data.PREFERENCE_FILE_KEY
import com.ggu.motion.databinding.FragmentResultBinding
import com.ggu.motion.ui.register.RegisterViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    private var viewModel: RegisterViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        setUpViewModel()

        binding.back.setOnClickListener { findNavController().popBackStack() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

    }

    private fun setUpViewModel() {
        val sharedPreferences = context?.getSharedPreferences(PREFERENCE_FILE_KEY, MODE_PRIVATE)

        viewModel =
            activity?.let {
                ViewModelFactory(
                    sharedPreferences!!,
                    it,
                    null
                ).create(RegisterViewModel::class.java)
            }
    }
}