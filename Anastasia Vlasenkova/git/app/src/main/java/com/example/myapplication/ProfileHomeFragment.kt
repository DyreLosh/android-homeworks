package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentHomeProfileBinding

class ProfileHomeFragment : Fragment() {
    var email: String? = null
    lateinit var binding: FragmentHomeProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeProfileBinding.inflate(inflater, container, false)
        binding.textHome.text = getString(R.string.home_title, email)
        binding.imageHomeExit.setOnClickListener() {
            activity?.finish()
        }
        return binding.root
    }
}
