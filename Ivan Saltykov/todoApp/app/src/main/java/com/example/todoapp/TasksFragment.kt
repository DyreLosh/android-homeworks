package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.FragmentTasksBinding
import com.google.android.material.tabs.TabLayoutMediator

class TasksFragment : Fragment() {
    lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        binding.viewPagerTasks.adapter = PagerAdapterTasks(this)
        TabLayoutMediator(binding.tabLayoutTasks, binding.viewPagerTasks) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.category_work)
                1 -> getString(R.string.category_study)
                2 -> getString(R.string.category_entertainments)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
