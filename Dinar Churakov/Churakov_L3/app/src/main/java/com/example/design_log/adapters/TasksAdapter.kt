package com.example.design_log.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.design_log.data.Task
import com.example.design_log.databinding.ItemTaskBinding

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    val items = mutableListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate (LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(tasks: List<Task>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }

    fun addItem(task: Task) {
        items.add(task)
        notifyItemInserted(items.lastIndex)
    }
}
