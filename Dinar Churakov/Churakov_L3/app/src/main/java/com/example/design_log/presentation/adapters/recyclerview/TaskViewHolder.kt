package com.example.design_log.presentation.adapters.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.design_log.data.https.model.TasksResponse
import com.example.design_log.databinding.ItemTaskBinding

class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        task: TasksResponse,
        onItemClick: (Int) -> Unit,
        onItemLongClick: (Int) -> Unit,
    ) =
        with(binding) {
            checkBox.isChecked = task.isCompleted
            taskText.text = task.text

            checkBox.setOnClickListener {
                checkBox.isChecked
                onItemClick.invoke(task.id)
            }

            root.setOnClickListener {
                checkBox.isChecked = !checkBox.isChecked
                onItemClick.invoke(task.id)
            }
            root.setOnLongClickListener {
                onItemLongClick.invoke(task.id)
                true
            }
        }
}
