package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val name = activity?.intent?.extras?.getString("Name")
        binding.collapsingToolbarProfile.title = getString(R.string.profile_name, name)
        binding.imageViewProfileOut.setOnClickListener {
            activity?.finish()
        }
        return binding.root
    }
}
