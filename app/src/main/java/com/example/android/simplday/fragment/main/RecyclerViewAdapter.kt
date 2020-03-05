package com.example.android.simplday.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.simplday.database.TaskForDatabase
import com.example.android.simplday.databinding.TaskItemBinding
import com.example.android.simplday.fragment.main.RecyclerViewAdapter.ViewHolder.Companion.from

class RecyclerViewAdapter(val clicklistener: TaskListener) :
    ListAdapter<TaskForDatabase, RecyclerViewAdapter.ViewHolder>(TaskForDatabaseDiffCallback()) {

    class ViewHolder private constructor(val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TaskForDatabase?, clicklistener: TaskListener?) {
            binding.tvPriority.text = item?.let { item.taskPriority }
            binding.tvTaskDescription.text = item?.let { item.taskName }
            binding.clickListener = clicklistener?.let { clicklistener }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: TaskForDatabase = getItem(position)!!
            holder.bind(item, clicklistener)
    }
}

class TaskForDatabaseDiffCallback : DiffUtil.ItemCallback<TaskForDatabase>() {
    override fun areItemsTheSame(oldItem: TaskForDatabase, newItem: TaskForDatabase): Boolean {
        return oldItem.taskId == newItem.taskId
    }

    override fun areContentsTheSame(oldItem: TaskForDatabase, newItem: TaskForDatabase): Boolean {
        return oldItem == newItem
    }

}

class TaskListener (val clickListener: (taskId: Long) -> Unit){
    fun onClick(task: TaskForDatabase) = clickListener(task.taskId)
}
// todo continue create clicklistener and make it work (for start let it show toast message)