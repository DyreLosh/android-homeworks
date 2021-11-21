package com.example.design_log

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.design_log.fragments.TasksFragment
import com.example.design_log.fragments.ViewPagerFragment


class MyPagerAdapter(fragment: TasksFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {

        return ViewPagerFragment(position)
    }
}
