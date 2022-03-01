package com.example.a1proect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentTaskListBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeTasksListFragment : Fragment() {
    lateinit var binding: FragmentTaskListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskListBinding.inflate(inflater, container, false)
        binding.taskFragmentPager?.adapter = MyPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.taskFragmentPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.fragment_task_pager_work)
                1 -> getString(R.string.fragment_task_pager_entertainment)
                2 -> getString(R.string.fragment_task_pager_study)
                else -> null
            }
        }.attach()
        return binding.root
    }
}
