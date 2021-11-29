package com.example.design_log.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.design_log.R
import com.example.design_log.databinding.FragmentTasksBinding
import com.example.design_log.viewHolderAdapter.MyPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class TasksFragment : Fragment() {

    lateinit var binding: FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = MyPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.tab_work)
                1 -> getString(R.string.tab_game)
                2 -> getString(R.string.tab_study)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
