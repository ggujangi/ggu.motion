package com.ggu.motion.ui.motion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ggu.motion.R
import com.ggu.motion.databinding.FragmentPlayerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class PlayerFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: FragmentPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerBinding.inflate(inflater, container, false)
        binding.navView.setOnNavigationItemSelectedListener(this)

        return binding.root
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == binding.navView.selectedItemId) {
            Toast.makeText(context, "It is same fragment", Toast.LENGTH_SHORT).show()
        } else {
            when (item.itemId) {
                R.id.menu_onair -> {
                    findNavController().navigate(R.id.nav_onair)
                }
                R.id.menu_vod -> {
                    findNavController().navigate(R.id.nav_vod)
                }
                R.id.menu_more -> {
                    findNavController().navigate(R.id.nav_more)
                }
            }

        }

        return true
    }
}