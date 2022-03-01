package com.example.a1proect

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return PagerFragment(position)
    }
}
