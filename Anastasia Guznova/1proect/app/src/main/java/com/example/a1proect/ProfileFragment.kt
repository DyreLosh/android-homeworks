package com.example.a1proect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val name = activity?.intent?.extras?.getString("Name")
        binding.profileCollapsing.title = getString(R.string.home_greeting, name)
        binding.iconExit.setOnClickListener {
            activity?.finish()
        }
        return binding.root
    }
}
