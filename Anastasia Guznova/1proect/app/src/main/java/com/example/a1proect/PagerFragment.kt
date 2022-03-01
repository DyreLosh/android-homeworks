package com.example.a1proect

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.a1proect.databinding.FragmentPagerBinding
import java.time.LocalDateTime

class PagerFragment(private val position: Int) : Fragment() {
    lateinit var binding: FragmentPagerBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dateTime = LocalDateTime.now()
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        val tasks = listOf(
            Task(
                nameTask = "Say Hi dkjhbfdhog shrthrtfglmfngh",
                time = dateTime
            ),
            Task(
                nameTask = "Fill out the documents",
                time = dateTime
            ),
            Task(
                nameTask = "Send documents",
                time = dateTime
            )
        )
        val adapter = TasksAdapter()
        binding.recyclerViewWork.adapter = adapter
        adapter.submitList(tasks)
        binding.button.setOnClickListener {
            adapter.addItem(
                Task(
                    nameTask = "Print documents",
                    time = dateTime
                )
            )
        }
        return binding.root
    }
}
