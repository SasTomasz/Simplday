package com.example.android.simplday.fragment.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.simplday.database.TaskDao

class TaskViewModelFactory(
    private val dataSource: TaskDao
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((TaskViewModel::class.java))) {
            return TaskViewModel(dataSource) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class")
    }
}