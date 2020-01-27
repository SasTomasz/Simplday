package com.example.android.simplday.fragment.task

import androidx.lifecycle.ViewModel
import com.example.android.simplday.database.TaskDao

class TaskViewModel(
    val database: TaskDao): ViewModel() {
}