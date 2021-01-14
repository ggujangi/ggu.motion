package com.ggu.motion.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggu.motion.databinding.FragmentOnairBinding

class OnAirFragment : Fragment() {

    private lateinit var binding: FragmentOnairBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnairBinding.inflate(inflater, container, false)

        return binding.root
    }
}