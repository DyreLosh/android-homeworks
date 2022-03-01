package com.example.a1proect

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.a1proect.databinding.ItemTaskBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(task: Task) = with(binding) {
        textViewNameTask.text = task.nameTask
        textViewTime.text = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("hh:mm:ss dd.MM.yyyy"))
    }
}
