package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todoapp.databinding.FragmentCategoryBinding
import java.time.LocalDateTime

class CategoryFragment : Fragment() {
    lateinit var binding: FragmentCategoryBinding
    val items = listOf(
        Task(
            "Have Lunch by 1pm1234567890",
            LocalDateTime.of(2021, 9, 1, 7, 0),
            false
        ),
        Task(
            "Have Lunch by 2pm",
            LocalDateTime.of(2021, 2, 22, 13, 0),
            false
        ),
        Task(
            "Have Lunch by 3pm",
            LocalDateTime.of(2021, 1, 29, 19, 0),
            false
        ),
    )
    val adapter = TasksAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        binding.recyclelViewCategory.adapter = adapter
        adapter.submitList(items)
        binding.floatingActionButtonCategory.setOnClickListener {
            adapter.addItem(
                Task(
                    "New task",
                    LocalDateTime.now(),
                    false
                )
            )
        }
        return binding.root
    }
}
