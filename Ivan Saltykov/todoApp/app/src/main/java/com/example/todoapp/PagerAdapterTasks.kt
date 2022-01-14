package com.example.todoapp

import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapterTasks(tasks_fragment: TasksFragment) : FragmentStateAdapter(tasks_fragment) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int) = CategoryFragment()
}
