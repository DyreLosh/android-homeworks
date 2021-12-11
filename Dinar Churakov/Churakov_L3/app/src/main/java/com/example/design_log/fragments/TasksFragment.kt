package com.example.design_log.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.design_log.R
import com.example.design_log.adapters.TasksAdapter
import com.example.design_log.data.Task
import com.example.design_log.databinding.FragmentTasksBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class TasksFragment : Fragment() {

    lateinit var binding: FragmentTasksBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("H.m M.d.y"))

        val tasks = listOf(
            Task(
                checkBox = false,
                taskText = getString(R.string.checkbox_text_1),
                date = date.toString()
            ),
            Task(

                checkBox = false,
                taskText = getString(R.string.checkbox_text_2),
                date = date.toString()
            ),
            Task(
                checkBox = false,
                taskText = getString(R.string.checkbox_text_3),
                date = date.toString()
            ),
            Task(
                checkBox = false,
                taskText = getString(R.string.checkbox_text_4),
                date = date.toString()
            ),
            Task(
                checkBox = false,
                taskText = getString(R.string.checkbox_text_5),
                date = date.toString()
            )
        )

        val adapter = TasksAdapter()
        binding.recyclerTask.adapter = adapter
        adapter.submitList(tasks)

        binding.newTaskButton.setOnClickListener {
            adapter.addItem(
                Task(
                    checkBox = false,
                    taskText = getString(R.string.checkbox_text_high),
                    date = date.toString()
                )
            )
        }
        return binding.root
    }
}
