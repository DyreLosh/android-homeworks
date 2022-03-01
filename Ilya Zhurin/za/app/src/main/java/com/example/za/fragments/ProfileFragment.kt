package com.example.za.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.za.R
import com.example.za.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.profileExit.setOnClickListener { activity?.finish() }
        val name = activity?.intent?.extras?.getString("Name")
        binding.profileText.text = getString(R.string.profile_greeting, name)
        return binding.root
    }
}
