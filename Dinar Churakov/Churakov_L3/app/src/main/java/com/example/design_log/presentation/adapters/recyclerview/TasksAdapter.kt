package com.example.design_log.presentation.adapters.recyclerview

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.design_log.data.https.model.TasksResponse
import com.example.design_log.databinding.ItemTaskBinding

class TasksAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    val items = mutableListOf<TasksResponse>()
    var onItemClick: (Int) -> Unit = {}
    var onItemLongClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position], onItemClick, onItemLongClick)
    }

    override fun getItemCount() = items.size

    fun submitList(tasks: List<TasksResponse>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
}
