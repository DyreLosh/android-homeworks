package com.example.design_log.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.design_log.R
import com.example.design_log.databinding.FragmentViewPagerBinding

class ViewPagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        binding.mainTextViewPager.text = when (position) {
            0 -> getString(R.string.tab_work)
            1 -> getString(R.string.tab_game)
            2 -> getString(R.string.tab_study)
            else -> null
        }
        return binding.root
    }
}
