package com.ggu.motion.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggu.motion.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    private lateinit var binding:FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        binding.title = "VOD"

        return binding.root
    }
}