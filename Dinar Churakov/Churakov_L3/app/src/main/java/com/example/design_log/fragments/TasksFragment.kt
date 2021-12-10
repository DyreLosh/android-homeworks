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

        val time = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT))
        val date = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))

        val tasks = listOf(
            Task(
                taskText = getString(R.string.checkbox_text_1),
                time = time.toString(),
                data = date.toString()
            ),
            Task(

                taskText = getString(R.string.checkbox_text_2),
                time = time.toString(),
                data = date.toString()
            ),
            Task(
                taskText = getString(R.string.checkbox_text_3),
                time = time.toString(),
                data = date.toString()
            ),
            Task(
                taskText = getString(R.string.checkbox_text_4),
                time = time.toString(),
                data = date.toString()
            ),
            Task(
                taskText = getString(R.string.checkbox_text_5),
                time = time.toString(),
                data = date.toString()
            )
        )

        val adapter = TasksAdapter()
        binding.recyclerTask.adapter = adapter
        adapter.submitList(tasks)

        binding.newTaskButton.setOnClickListener {
            adapter.addItem(
                Task(
                    taskText = getString(R.string.checkbox_text_high),
                    time = time.toString(),
                    data = date.toString()
                )
            )
        }
        return binding.root
    }
}
