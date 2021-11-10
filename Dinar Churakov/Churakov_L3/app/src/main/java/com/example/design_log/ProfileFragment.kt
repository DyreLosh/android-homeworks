package com.example.design_log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.design_log.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.logOutButton.setOnClickListener {
            activity?.finish()
        }
        val name = activity?.intent?.extras?.getString("Name")
        binding.welcomeTextProfileActivity.text = getString(R.string.welcome_profile, name)

        return binding.root
    }
}
