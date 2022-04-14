package com.example.design_log.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.design_log.common.preference.PreferenceManager
import com.example.design_log.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val preferenceManager = PreferenceManager(requireContext())
        binding.welcomeProfileText.text = preferenceManager.readPersonNamePreference()
        return binding.root
    }
}
