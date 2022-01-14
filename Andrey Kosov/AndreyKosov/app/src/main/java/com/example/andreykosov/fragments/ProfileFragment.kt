package com.example.andreykosov.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andreykosov.R
import com.example.andreykosov.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    var variable: Int? = null
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.imageButtonProfileFragmentLogout.setOnClickListener {
            activity?.finish()
        }
        val name = activity?.intent?.extras?.getString("Name")
        binding.textViewProfileFragmentEmail.text = getString(R.string.profile_greeting, name)
        return binding.root
    }
}
