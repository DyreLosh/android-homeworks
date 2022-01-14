package com.example.todoapp

import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTaskBinding
import java.time.format.DateTimeFormatter

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(task: Task) = with(binding) {
        textViewItemTaskName.text = task.nameTask
        textViewItemTaskTime.text = task.timeGenerationTask
            .format(DateTimeFormatter.ofPattern("HH:mm dd.MM.y"))
        root.setOnClickListener {
            binding.checkBoxItemTask.isChecked = !binding.checkBoxItemTask.isChecked
        }
    }
}
