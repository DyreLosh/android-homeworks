package com.example.design_log.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.design_log.data.Task
import com.example.design_log.databinding.ItemTaskBinding

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(task: Task) = with(binding) {
        taskText.text = task.taskText
        timeText.text = task.time
        dataText.text = task.data
    }
}