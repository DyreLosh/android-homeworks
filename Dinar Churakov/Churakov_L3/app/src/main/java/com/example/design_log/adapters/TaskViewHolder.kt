package com.example.design_log.adapters

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.design_log.data.Task
import com.example.design_log.databinding.ItemTaskBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(task: Task) = with(binding) {
        checkBox.isChecked = task.completedTask
        taskText.text = task.taskText
        dateText.text = LocalDateTime.now().format(DateTimeFormatter.ofPattern("H:m M.d.y"))

        root.setOnClickListener {
            checkBox.isChecked = !checkBox.isChecked
        }
    }
}
