package com.example.android.simplday.fragment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.simplday.database.TaskForDatabase
import com.example.android.simplday.databinding.TaskItemBinding
import com.example.android.simplday.fragment.main.RecyclerViewAdapter.ViewHolder.Companion.from

class RecyclerViewAdapter :
    ListAdapter<TaskForDatabase, RecyclerViewAdapter.ViewHolder>(TaskForDatabaseDiffCallback()) {

    class ViewHolder private constructor(val binding: TaskItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TaskForDatabase) {
            binding.tvPriority.text = item.taskPriority
            binding.tvTaskDescription.text = item.taskName
        }

        // todo 2020-03-05 make recycler adapter without databinding

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
        val item = getItem(position)
        holder.bind(item)
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